public class Instruments {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Grand Piano", "Wood", 88),
            new Guitar("Acoustic Guitar", "Wood", 6),
            new Drum("Bass Drum", "Metal", "Percussion")
        };

        for (Instrument i : instruments) {
            System.out.println("Instrument: " + i.name + ", Material: " + i.material);
            i.play();
        }
    }
}

class Instrument {
    protected String name;
    protected String material;

    Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    void play() {
        System.out.println("Playing an instrument");
    }
}

class Piano extends Instrument {
    protected int keys;

    Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }

    @Override
    void play() {
        System.out.println("Piano with " + keys + " keys is playing");
    }
}

class Guitar extends Instrument {
    protected int strings;

    Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }

    @Override
    void play() {
        System.out.println("Guitar with " + strings + " strings is playing");
    }
}

class Drum extends Instrument {
    protected String type;

    Drum(String name, String material, String type) {
        super(name, material);
        this.type = type;
    }

    @Override
    void play() {
        System.out.println("Drum of type " + type + " is playing");
    }
}
