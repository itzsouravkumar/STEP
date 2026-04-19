public class UseCase15SafeCargoAssignmentUsingTryCatchFinally {
    static class CargoSafetyException extends RuntimeException {
        CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        private final String shape;
        private String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
            this.cargo = "Unassigned";
        }

        public String getShape() {
            return shape;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return shape + " -> " + cargo;
        }
    }

    public static boolean assignCargoSafely(GoodsBogie bogie, String cargo) {
        try {
            validateCargoCompatibility(bogie, cargo);
            bogie.setCargo(cargo);
            System.out.println("Cargo assigned successfully: " + bogie);
            return true;
        } catch (CargoSafetyException e) {
            System.out.println("Cargo assignment failed: " + e.getMessage());
            return false;
        } finally {
            System.out.println("Cargo assignment validation completed for: " + bogie.getShape());
        }
    }

    private static void validateCargoCompatibility(GoodsBogie bogie, String cargo) {
        if (bogie.getShape().equalsIgnoreCase("Rectangular")
                && cargo.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("Petroleum cannot be assigned to Rectangular bogie");
        }
    }

    public static void main(String[] args) {
        System.out.println("UC15 - Safe Cargo Assignment Using try-catch-finally");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        GoodsBogie open = new GoodsBogie("Open");

        assignCargoSafely(cylindrical, "Petroleum");
        assignCargoSafely(rectangular, "Petroleum");
        assignCargoSafely(open, "Coal");

        System.out.println("Final Goods Bogies State:");
        System.out.println(cylindrical);
        System.out.println(rectangular);
        System.out.println(open);
        System.out.println("UC15 runtime exception handling completed...");
    }
}
