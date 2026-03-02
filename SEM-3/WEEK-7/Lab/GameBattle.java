public class GameBattle {
    public static void main(String[] args) {
        Character[] army = new Character[3];
        army[0] = new Warrior("Thor");
        army[1] = new Mage("Merlin", 30);
        army[2] = new Archer("Legolas");

        for (Character c : army) {
            c.attack();
        }
    }
}

class Character {
    protected String name;

    public Character(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println(name + " attacks in a basic way.");
    }
}

class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + " swings a sword with high defense!");
    }
}

class Mage extends Character {
    private int mana;

    public Mage(String name, int mana) {
        super(name);
        this.mana = mana;
    }

    @Override
    public void attack() {
        if (mana >= 10) {
            System.out.println(name + " casts a powerful spell using 10 mana!");
            mana -= 10;
        } else {
            System.out.println(name + " tries to cast a spell but doesn't have enough mana!");
        }
    }
}

class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + " shoots an arrow from long range!");
    }
}