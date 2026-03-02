public class Hammer extends Tool {
    Hammer(String id, String material, String name) {
        super(id, material, name);
    }

    void showAccess() {
        // System.out.println("ID: " + id); //  Not accessible (private)
        System.out.println("ID: " + getId()); // Accessible via getter
        System.out.println("Material: " + material); // Accessible (protected)
        System.out.println("Name: " + name); // Accessible (public)
    }

    public static void main(String[] args) {
        Hammer h = new Hammer("H101", "Steel", "Claw Hammer");
        h.showAccess();
    }
}

class Tool {
    private String id;
    protected String material;
    public String name;

    Tool(String id, String material, String name) {
        this.id = id;
        this.material = material;
        this.name = name;
    }

    public String getId() {
        return id;
    }
}