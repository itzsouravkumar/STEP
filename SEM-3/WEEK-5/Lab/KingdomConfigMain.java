import java.util.*;

public class KingdomConfigMain {
    public static void main(String[] args) {
        KingdomConfig config = KingdomConfig.createDefaultKingdom();
        KingdomManager manager = new KingdomManager(config);

        WizardTower tower = new WizardTower(100, Arrays.asList("Fireball", "Shield"), "Merlin");
        EnchantedCastle castle = new EnchantedCastle("Royal Castle", 300, true);
        MysticLibrary library = new MysticLibrary(Map.of("Book of Spells", "Fire Magic"), 200);
        DragonLair lair = new DragonLair("Fire Dragon", 5000, 200);

        manager.addStructure(tower);
        manager.addStructure(castle);
        manager.addStructure(library);
        manager.addStructure(lair);

        System.out.println(manager);
        System.out.println("Can Tower and Library interact? " + KingdomManager.canStructuresInteract(tower, library));
        System.out.println(KingdomManager.performMagicBattle(tower, lair));
        System.out.println("Kingdom Power: " + KingdomManager.calculateKingdomPower(new Object[]{tower, castle, library, lair}));
    }
}


final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String kingdomName, int foundingYear, String[] allowedStructureTypes, Map<String, Integer> resourceLimits) {
        if (kingdomName == null || kingdomName.isEmpty() || foundingYear <= 0 || allowedStructureTypes == null || resourceLimits == null) {
            throw new IllegalArgumentException("Invalid kingdom configuration");
        }
        this.kingdomName = kingdomName;
        this.foundingYear = foundingYear;
        this.allowedStructureTypes = Arrays.copyOf(allowedStructureTypes, allowedStructureTypes.length);
        this.resourceLimits = new HashMap<>(resourceLimits);
    }

    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return Arrays.copyOf(allowedStructureTypes, allowedStructureTypes.length); }
    public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }

    public static KingdomConfig createDefaultKingdom() {
        return new KingdomConfig("Avaloria", 1000, new String[]{"WizardTower", "EnchantedCastle", "MysticLibrary", "DragonLair"}, Map.of("Gold", 10000, "Mana", 5000));
    }

    public static KingdomConfig createFromTemplate(String type) {
        if ("Royal".equalsIgnoreCase(type)) {
            return new KingdomConfig("Royalia", 1200, new String[]{"EnchantedCastle", "WizardTower"}, Map.of("Gold", 20000, "Mana", 8000));
        }
        if ("Mystic".equalsIgnoreCase(type)) {
            return new KingdomConfig("Mystara", 800, new String[]{"MysticLibrary", "WizardTower"}, Map.of("Gold", 7000, "Mana", 12000));
        }
        return createDefaultKingdom();
    }

    @Override
    public String toString() {
        return "KingdomConfig{" +
                "kingdomName='" + kingdomName + '\'' +
                ", foundingYear=" + foundingYear +
                ", allowedStructureTypes=" + Arrays.toString(allowedStructureTypes) +
                ", resourceLimits=" + resourceLimits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KingdomConfig)) return false;
        KingdomConfig that = (KingdomConfig) o;
        return foundingYear == that.foundingYear &&
                Objects.equals(kingdomName, that.kingdomName) &&
                Arrays.equals(allowedStructureTypes, that.allowedStructureTypes) &&
                Objects.equals(resourceLimits, that.resourceLimits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(kingdomName, foundingYear, resourceLimits);
        result = 31 * result + Arrays.hashCode(allowedStructureTypes);
        return result;
    }
}

class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;
    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;

    static final int MIN_MAGIC_POWER = 0;
    static final int MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    public MagicalStructure(String name, String location) {
        this(name, location, 100, true);
    }

    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true);
    }

    public MagicalStructure(String name, String location, int power, boolean active) {
        if (name == null || name.isEmpty() || location == null || location.isEmpty() || power < MIN_MAGIC_POWER || power > MAX_MAGIC_POWER) {
            throw new IllegalArgumentException("Invalid structure data");
        }
        this.structureId = UUID.randomUUID().toString();
        this.constructionTimestamp = System.currentTimeMillis();
        this.structureName = name;
        this.location = location;
        this.magicPower = power;
        this.isActive = active;
        this.currentMaintainer = "Unknown";
    }

    public String getStructureId() { return structureId; }
    public long getConstructionTimestamp() { return constructionTimestamp; }
    public String getStructureName() { return structureName; }
    public String getLocation() { return location; }
    public int getMagicPower() { return magicPower; }
    public void setMagicPower(int magicPower) {
        if (magicPower < MIN_MAGIC_POWER || magicPower > MAX_MAGIC_POWER) throw new IllegalArgumentException("Invalid magic power");
        this.magicPower = magicPower;
    }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
    public String getCurrentMaintainer() { return currentMaintainer; }
    public void setCurrentMaintainer(String currentMaintainer) { this.currentMaintainer = currentMaintainer; }

    @Override
    public String toString() {
        return "MagicalStructure{" +
                "id='" + structureId + '\'' +
                ", name='" + structureName + '\'' +
                ", location='" + location + '\'' +
                ", magicPower=" + magicPower +
                ", isActive=" + isActive +
                ", maintainer='" + currentMaintainer + '\'' +
                '}';
    }
}

class WizardTower {
    private final int maxSpellCapacity;
    private List<String> knownSpells;
    private String currentWizard;

    public WizardTower() {
        this(50, new ArrayList<>(), "None");
    }

    public WizardTower(int maxSpellCapacity, List<String> spells) {
        this(maxSpellCapacity, new ArrayList<>(spells), "Apprentice");
    }

    public WizardTower(int maxSpellCapacity, List<String> spells, String wizard) {
        this.maxSpellCapacity = maxSpellCapacity;
        this.knownSpells = new ArrayList<>(spells);
        this.currentWizard = wizard;
    }

    public int getMaxSpellCapacity() { return maxSpellCapacity; }
    public List<String> getKnownSpells() { return new ArrayList<>(knownSpells); }
    public void addSpell(String spell) { if (knownSpells.size() < maxSpellCapacity) knownSpells.add(spell); }
    public String getCurrentWizard() { return currentWizard; }
    public void setCurrentWizard(String currentWizard) { this.currentWizard = currentWizard; }

    @Override
    public String toString() {
        return "WizardTower{" +
                "maxSpellCapacity=" + maxSpellCapacity +
                ", knownSpells=" + knownSpells +
                ", currentWizard='" + currentWizard + '\'' +
                '}';
    }
}

class EnchantedCastle {
    private final String castleType;
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String castleType) {
        this(castleType, 100, true);
    }

    public EnchantedCastle(String castleType, int defense) {
        this(castleType, defense, true);
    }

    public EnchantedCastle(String castleType, int defense, boolean drawbridge) {
        this.castleType = castleType;
        this.defenseRating = defense;
        this.hasDrawbridge = drawbridge;
    }

    public String getCastleType() { return castleType; }
    public int getDefenseRating() { return defenseRating; }
    public void setDefenseRating(int defenseRating) { this.defenseRating = defenseRating; }
    public boolean isHasDrawbridge() { return hasDrawbridge; }
    public void setHasDrawbridge(boolean hasDrawbridge) { this.hasDrawbridge = hasDrawbridge; }

    @Override
    public String toString() {
        return "EnchantedCastle{" +
                "castleType='" + castleType + '\'' +
                ", defenseRating=" + defenseRating +
                ", hasDrawbridge=" + hasDrawbridge +
                '}';
    }
}

class MysticLibrary {
    private final Map<String, String> bookCollection;
    private int knowledgeLevel;

    public MysticLibrary() {
        this(new HashMap<>(), 10);
    }

    public MysticLibrary(Map<String, String> books) {
        this(books, 50);
    }

    public MysticLibrary(Map<String, String> books, int level) {
        this.bookCollection = new HashMap<>(books);
        this.knowledgeLevel = level;
    }

    public Map<String, String> getBookCollection() { return new HashMap<>(bookCollection); }
    public void addBook(String title, String content) { bookCollection.put(title, content); }
    public int getKnowledgeLevel() { return knowledgeLevel; }
    public void setKnowledgeLevel(int knowledgeLevel) { this.knowledgeLevel = knowledgeLevel; }

    @Override
    public String toString() {
        return "MysticLibrary{" +
                "bookCollection=" + bookCollection.keySet() +
                ", knowledgeLevel=" + knowledgeLevel +
                '}';
    }
}

class DragonLair {
    private final String dragonType;
    private long treasureValue;
    private int territorialRadius;

    public DragonLair(String dragonType) {
        this(dragonType, 1000, 50);
    }

    public DragonLair(String dragonType, long treasureValue) {
        this(dragonType, treasureValue, 100);
    }

    public DragonLair(String dragonType, long treasureValue, int radius) {
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
        this.territorialRadius = radius;
    }

    public String getDragonType() { return dragonType; }
    public long getTreasureValue() { return treasureValue; }
    public void setTreasureValue(long treasureValue) { this.treasureValue = treasureValue; }
    public int getTerritorialRadius() { return territorialRadius; }
    public void setTerritorialRadius(int territorialRadius) { this.territorialRadius = territorialRadius; }

    @Override
    public String toString() {
        return "DragonLair{" +
                "dragonType='" + dragonType + '\'' +
                ", treasureValue=" + treasureValue +
                ", territorialRadius=" + territorialRadius +
                '}';
    }
}

class KingdomManager {
    private final List<Object> structures;
    private final KingdomConfig config;

    public KingdomManager(KingdomConfig config) {
        this.config = config;
        this.structures = new ArrayList<>();
    }

    public void addStructure(Object structure) {
        structures.add(structure);
    }

    public static boolean canStructuresInteract(Object s1, Object s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) return true;
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) return true;
        return false;
    }

    public static String performMagicBattle(Object attacker, Object defender) {
        if (attacker instanceof WizardTower && defender instanceof DragonLair) return "WizardTower casts spells against Dragon!";
        if (attacker instanceof DragonLair && defender instanceof EnchantedCastle) return "Dragon attacks the Castle!";
        return "No battle occurred";
    }

    public static int calculateKingdomPower(Object[] structures) {
        int total = 0;
        for (Object s : structures) {
            if (s instanceof WizardTower) total += ((WizardTower) s).getMaxSpellCapacity();
            if (s instanceof EnchantedCastle) total += ((EnchantedCastle) s).getDefenseRating();
            if (s instanceof MysticLibrary) total += ((MysticLibrary) s).getKnowledgeLevel();
            if (s instanceof DragonLair) total += ((DragonLair) s).getTerritorialRadius();
        }
        return total;
    }

    private String determineStructureCategory(Object structure) {
        if (structure instanceof WizardTower) return "Wizard Structure";
        if (structure instanceof EnchantedCastle) return "Defensive Structure";
        if (structure instanceof MysticLibrary) return "Knowledge Structure";
        if (structure instanceof DragonLair) return "Beast Lair";
        return "Unknown";
    }

    @Override
    public String toString() {
        return "KingdomManager{" +
                "config=" + config +
                ", structures=" + structures +
                '}';
    }
}