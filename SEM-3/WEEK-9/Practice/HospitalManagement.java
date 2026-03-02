package Practice;
public class HospitalManagement {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Hospital.Department dept1 = hospital.createDepartment("Cardiology");
        Hospital.Department dept2 = hospital.createDepartment("Neurology");

        dept1.displayInfo();
        dept2.displayInfo();
    }
}

class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    public class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayInfo() {
            System.out.println("Hospital: " + Hospital.this.name + ", Department: " + deptName);
        }
    }

    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }
}