import java.util.*;

class VirtualPet {
    final String petId;
    String petName;
    String species;
    int age;
    int happiness;
    int health;
    String currentStage;
    boolean isGhost;
    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    static int totalPetsCreated = 0;

    public VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 0, 60, 60, EVOLUTION_STAGES[1]);
    }

    public VirtualPet(String petName, String species) {
        this(petName, species, 2, 70, 70, EVOLUTION_STAGES[2]);
    }

    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.currentStage = stage;
        this.isGhost = false;
        totalPetsCreated++;
    }

    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Wolf", "Cat"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }

    public void evolvePet() {
        if (isGhost) return;
        int stageIndex = Arrays.asList(EVOLUTION_STAGES).indexOf(currentStage);
        if (stageIndex < EVOLUTION_STAGES.length - 1) {
            if (age > stageIndex * 2 && happiness > 30 && health > 30) {
                currentStage = EVOLUTION_STAGES[stageIndex + 1];
                System.out.println(petName + " has evolved into " + currentStage + " stage!");
            }
        }
    }

    public void feedPet() {
        if (isGhost) return;
        happiness += 5;
        health += 10;
    }

    public void playWithPet() {
        if (isGhost) return;
        happiness += 10;
        health -= 5;
    }

    public void healPet() {
        if (isGhost) return;
        health += 15;
    }

    public void simulateDay() {
        if (isGhost) return;
        age++;
        happiness -= new Random().nextInt(6);
        health -= new Random().nextInt(6);
        if (health <= 0) {
            isGhost = true;
            currentStage = "Ghost";
            System.out.println(petName + " has died and become a Ghost...");
        } else {
            evolvePet();
        }
    }

    public String getPetStatus() {
        return petName + " [" + species + "] - Stage: " + currentStage + ", Age: " + age + ", Happiness: " + happiness + ", Health: " + health + (isGhost ? " (Ghost)" : "");
    }
}

public class VirtualPetSimulator {
    public static void main(String[] args) {
        List<VirtualPet> daycare = new ArrayList<>();
        daycare.add(new VirtualPet());
        daycare.add(new VirtualPet("Fluffy"));
        daycare.add(new VirtualPet("Sparky", "Dog"));
        daycare.add(new VirtualPet("Draco", "Dragon", 3, 80, 90, "Teen"));

        for (int day = 1; day <= 5; day++) {
            System.out.println("\n--- Day " + day + " ---");
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                pet.feedPet();
                pet.playWithPet();
                pet.healPet();
                System.out.println(pet.getPetStatus());
            }
        }
        System.out.println("\nTotal Pets Created: " + VirtualPet.totalPetsCreated);
    }
}