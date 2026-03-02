import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class VirtualPetMain {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Buddy");
        PetSpecies dragonSpecies = new PetSpecies("Dragon", new String[]{"Hatchling", "Young", "Ancient"}, 500, "Mountains");
        VirtualPet pet3 = new VirtualPet("Draco", dragonSpecies);

        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        pet2.feedPet("fruit");
        pet2.playWithPet("fetch");
        System.out.println("After feeding and playing: " + pet2.getInternalState());

        DragonPet dragon = new DragonPet("Fire Dragon", "Flame Breath");
        RobotPet robot = new RobotPet(true, 80);

        System.out.println(dragon);
        System.out.println(robot);
    }
}


class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    private String petName;
    private int age;
    private int happiness;
    private int health;

    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Baby", "Teen", "Adult"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    public VirtualPet() {
        this("Pet" + UUID.randomUUID().toString().substring(0, 5), 
             new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 100, "Generic"), 
             0, 50, 50);
    }

    public VirtualPet(String name) {
        this(name, new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 100, "Generic"), 0, 50, 50);
    }

    public VirtualPet(String name, PetSpecies species) {
        this(name, species, 0, 50, 50);
    }

    public VirtualPet(String name, PetSpecies species, int age, int happiness, int health) {
        validateStat(happiness);
        validateStat(health);
        this.petId = generatePetId();
        this.species = species;
        this.birthTimestamp = System.currentTimeMillis();
        this.petName = name;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
    }

    public String getPetId() { return petId; }
    public PetSpecies getSpecies() { return species; }
    public long getBirthTimestamp() { return birthTimestamp; }
    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) { validateStat(happiness); this.happiness = happiness; }
    public int getHealth() { return health; }
    public void setHealth(int health) { validateStat(health); this.health = health; }

    public void feedPet(String foodType) {
        int bonus = calculateFoodBonus(foodType);
        modifyHealth(bonus);
    }

    public void playWithPet(String gameType) {
        int effect = calculateGameEffect(gameType);
        modifyHappiness(effect);
    }

    protected int calculateFoodBonus(String foodType) {
        if (foodType.equalsIgnoreCase("fruit")) return 10;
        if (foodType.equalsIgnoreCase("meat")) return 15;
        return 5;
    }

    protected int calculateGameEffect(String gameType) {
        if (gameType.equalsIgnoreCase("fetch")) return 10;
        if (gameType.equalsIgnoreCase("race")) return 15;
        return 5;
    }

    private void modifyHappiness(int amount) {
        this.happiness = Math.min(MAX_HAPPINESS, this.happiness + amount);
        checkEvolution();
    }

    private void modifyHealth(int amount) {
        this.health = Math.min(MAX_HEALTH, this.health + amount);
    }

    private void updateEvolutionStage() {
    }

    private void validateStat(int value) {
        if (value < 0 || value > 100) throw new IllegalArgumentException("Invalid stat value");
    }

    private String generatePetId() {
        return UUID.randomUUID().toString();
    }

    private void checkEvolution() {
        updateEvolutionStage();
    }

    String getInternalState() {
        return "Name: " + petName + " Age: " + age + " Happiness: " + happiness + " Health: " + health;
    }

    @Override
    public String toString() {
        return "VirtualPet{" +
                "petId='" + petId + '\'' +
                ", species=" + species +
                ", petName='" + petName + '\'' +
                ", age=" + age +
                ", happiness=" + happiness +
                ", health=" + health +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualPet)) return false;
        VirtualPet that = (VirtualPet) o;
        return Objects.equals(petId, that.petId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }
}

final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if (speciesName == null || evolutionStages == null || evolutionStages.length == 0 || maxLifespan <= 0 || habitat == null) {
            throw new IllegalArgumentException("Invalid species data");
        }
        this.speciesName = speciesName;
        this.evolutionStages = Arrays.copyOf(evolutionStages, evolutionStages.length);
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }
    public String[] getEvolutionStages() { return Arrays.copyOf(evolutionStages, evolutionStages.length); }
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }

    @Override
    public String toString() {
        return "PetSpecies{" +
                "speciesName='" + speciesName + '\'' +
                ", maxLifespan=" + maxLifespan +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}

class DragonPet {
    private final String dragonType;
    private final String breathWeapon;

    public DragonPet(String dragonType, String breathWeapon) {
        this.dragonType = dragonType;
        this.breathWeapon = breathWeapon;
    }

    public String getDragonType() { return dragonType; }
    public String getBreathWeapon() { return breathWeapon; }

    @Override
    public String toString() {
        return "DragonPet{" +
                "dragonType='" + dragonType + '\'' +
                ", breathWeapon='" + breathWeapon + '\'' +
                '}';
    }
}

class RobotPet {
    private boolean needsCharging;
    private int batteryLevel;

    public RobotPet(boolean needsCharging, int batteryLevel) {
        this.needsCharging = needsCharging;
        this.batteryLevel = batteryLevel;
    }

    public boolean isNeedsCharging() { return needsCharging; }
    public void setNeedsCharging(boolean needsCharging) { this.needsCharging = needsCharging; }
    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) throw new IllegalArgumentException("Invalid battery level");
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return "RobotPet{" +
                "needsCharging=" + needsCharging +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
