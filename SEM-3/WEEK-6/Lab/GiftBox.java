class GiftBox extends Box {
    @Override
    void pack() {
        super.pack();
        System.out.println("Adding ribbon and decoration for gift box");
    }

    @Override
    void unpack() {
        super.unpack();
        System.out.println("Removing ribbon and gift wrap");
    }

    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}

class Box {
    void pack() {
        System.out.println("Box is being packed");
    }

    void unpack() {
        System.out.println("Box is being unpacked");
    }
}

