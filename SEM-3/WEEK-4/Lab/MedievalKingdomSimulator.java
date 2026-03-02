abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    public MagicalStructure() {
        this("Unknown", 0, "Unknown", false);
    }

    public MagicalStructure(String structureName) {
        this(structureName, 50, "Unknown", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;

    public WizardTower() {
        this("Wizard Tower", 100, "Hilltop", true, 5, new String[]{"Fireball"});
    }

    public WizardTower(String structureName, int spellCapacity, String[] spells) {
        this(structureName, 120, "Valley", true, spellCapacity, spells);
    }

    public WizardTower(String structureName, int magicPower, String location, boolean isActive, int spellCapacity, String[] spells) {
        super(structureName, magicPower, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = spells;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a powerful spell!");
    }
}

class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    public EnchantedCastle() {
        this("Simple Fort", 80, "Plains", true, 50, false);
    }

    public EnchantedCastle(String structureName, int defenseRating) {
        this(structureName, 100, "Highland", true, defenseRating, true);
    }

    public EnchantedCastle(String structureName, int magicPower, String location, boolean isActive, int defenseRating, boolean hasDrawbridge) {
        super(structureName, magicPower, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " radiates a defensive aura!");
    }
}

class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    public MysticLibrary() {
        this("Small Library", 60, "Village", true, 100, "Latin");
    }

    public MysticLibrary(String structureName, int bookCount, String ancientLanguage) {
        this(structureName, 90, "Capital", true, bookCount, ancientLanguage);
    }

    public MysticLibrary(String structureName, int magicPower, String location, boolean isActive, int bookCount, String ancientLanguage) {
        super(structureName, magicPower, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " reveals hidden knowledge!");
    }
}

class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    public DragonLair() {
        this("Dragon Lair", 150, "Mountain", true, "Fire Dragon", 1000);
    }

    public DragonLair(String dragonType, int treasureValue) {
        this("Custom Lair", 170, "Cave", true, dragonType, treasureValue);
    }

    public DragonLair(String structureName, int magicPower, String location, boolean isActive, String dragonType, int treasureValue) {
        super(structureName, magicPower, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fury!");
    }
}

class KingdomUtils {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1.isActive && s2.isActive;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " wins over " + defender.structureName;
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " withstands the attack of " + attacker.structureName;
        } else {
            return "The battle between " + attacker.structureName + " and " + defender.structureName + " ends in a draw!";
        }
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
}

class KingdomManager {
    public static void categorizeStructures(MagicalStructure[] structures) {
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) {
                System.out.println(s.structureName + " categorized as Wizard Tower.");
            } else if (s instanceof EnchantedCastle) {
                System.out.println(s.structureName + " categorized as Enchanted Castle.");
            } else if (s instanceof MysticLibrary) {
                System.out.println(s.structureName + " categorized as Mystic Library.");
            } else if (s instanceof DragonLair) {
                System.out.println(s.structureName + " categorized as Dragon Lair.");
            }
        }
    }

    public static void calculateTax(MagicalStructure[] structures) {
        for (MagicalStructure s : structures) {
            double tax;
            if (s instanceof WizardTower) {
                tax = s.magicPower * 0.1;
            } else if (s instanceof EnchantedCastle) {
                tax = s.magicPower * 0.15;
            } else if (s instanceof MysticLibrary) {
                tax = s.magicPower * 0.05;
            } else if (s instanceof DragonLair) {
                tax = s.magicPower * 0.2;
            } else {
                tax = s.magicPower * 0.1;
            }
            System.out.println(s.structureName + " pays tax: " + tax);
        }
    }

    public static void determineSpecialization(MagicalStructure[] structures) {
        int magicFocus = 0, defenseFocus = 0;
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower || s instanceof MysticLibrary) {
                magicFocus += s.magicPower;
            } else if (s instanceof EnchantedCastle || s instanceof DragonLair) {
                defenseFocus += s.magicPower;
            }
        }
        if (magicFocus > defenseFocus) {
            System.out.println("Kingdom specialization: Magic-focused");
        } else if (defenseFocus > magicFocus) {
            System.out.println("Kingdom specialization: Defense-focused");
        } else {
            System.out.println("Kingdom specialization: Balanced");
        }
    }
}

public class MedievalKingdomSimulator {
    public static void main(String[] args) {
        MagicalStructure[] kingdom = {
                new WizardTower(),
                new EnchantedCastle(),
                new MysticLibrary(),
                new DragonLair(),
                new WizardTower("Arcane Tower", 10, new String[]{"Lightning", "Shield"})
        };

        for (MagicalStructure s : kingdom) {
            s.castMagicSpell();
        }

        KingdomManager.categorizeStructures(kingdom);
        KingdomManager.calculateTax(kingdom);
        KingdomManager.determineSpecialization(kingdom);

        System.out.println(KingdomUtils.performMagicBattle(kingdom[0], kingdom[1]));
        System.out.println("Total Kingdom Magic Power: " + KingdomUtils.calculateKingdomMagicPower(kingdom));
    }
}