public class HospitalSystem {
    public static void main(String[] args) {
        MedicalStaff[] staff = new MedicalStaff[4];
        staff[0] = new Doctor("Dr. Alice", "D101");
        staff[1] = new Nurse("Nurse Bob", "N202");
        staff[2] = new Technician("Tech Charlie", "T303");
        staff[3] = new Administrator("Admin Dana", "A404");

        for (MedicalStaff m : staff) {
            m.scheduleShift();
            m.accessIDCard();
            m.processPayroll();
            System.out.println();
        }

        ((Doctor) staff[0]).diagnose();
        ((Doctor) staff[0]).prescribeMedicine();
        ((Doctor) staff[0]).performSurgery();

        ((Nurse) staff[1]).administerMedicine();
        ((Nurse) staff[1]).monitorPatient();
        ((Nurse) staff[1]).assistProcedure();

        ((Technician) staff[2]).operateEquipment();
        ((Technician) staff[2]).runTests();
        ((Technician) staff[2]).maintainInstruments();

        ((Administrator) staff[3]).scheduleAppointments();
        ((Administrator) staff[3]).manageRecords();
    }
}

class MedicalStaff {
    protected String name;
    protected String staffID;

    public MedicalStaff(String name, String staffID) {
        this.name = name;
        this.staffID = staffID;
    }

    public void scheduleShift() {
        System.out.println(name + " has a scheduled shift.");
    }

    public void accessIDCard() {
        System.out.println(name + " accessed ID card.");
    }

    public void processPayroll() {
        System.out.println(name + "'s payroll processed.");
    }
}

class Doctor extends MedicalStaff {
    public Doctor(String name, String staffID) {
        super(name, staffID);
    }

    public void diagnose() {
        System.out.println(name + " is diagnosing a patient.");
    }

    public void prescribeMedicine() {
        System.out.println(name + " prescribed medicine.");
    }

    public void performSurgery() {
        System.out.println(name + " is performing surgery.");
    }
}

class Nurse extends MedicalStaff {
    public Nurse(String name, String staffID) {
        super(name, staffID);
    }

    public void administerMedicine() {
        System.out.println(name + " administered medicine.");
    }

    public void monitorPatient() {
        System.out.println(name + " is monitoring a patient.");
    }

    public void assistProcedure() {
        System.out.println(name + " assisted in a procedure.");
    }
}

class Technician extends MedicalStaff {
    public Technician(String name, String staffID) {
        super(name, staffID);
    }

    public void operateEquipment() {
        System.out.println(name + " is operating medical equipment.");
    }

    public void runTests() {
        System.out.println(name + " ran medical tests.");
    }

    public void maintainInstruments() {
        System.out.println(name + " maintained instruments.");
    }
}

class Administrator extends MedicalStaff {
    public Administrator(String name, String staffID) {
        super(name, staffID);
    }

    public void scheduleAppointments() {
        System.out.println(name + " scheduled appointments.");
    }

    public void manageRecords() {
        System.out.println(name + " managed hospital records.");
    }
}