class SmartPhone extends Phone {
    protected String operatingSystem;

    SmartPhone() {
        super();
        System.out.println("SmartPhone default constructor");
    }

    SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone parameterized constructor");
    }

    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone();
        SmartPhone s2 = new SmartPhone("Samsung", "Galaxy S24", "Android");
        System.out.println(s2.brand + " " + s2.model + " " + s2.operatingSystem);
    }
}

class Phone {
    protected String brand;
    protected String model;

    Phone() {
        System.out.println("Phone default constructor");
    }

    Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone parameterized constructor");
    }
}

