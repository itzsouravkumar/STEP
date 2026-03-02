public class UniversityDemo {
    public static void main(String[] args) {
        University uni = new University("Global University");

        University.Department dept = uni.new Department("Computer Science");
        dept.displayDepartmentInfo();

        University.ExamCell.conductExam("Mathematics");
        University.ExamCell.announceResults("Spring 2025");
    }
}

class University {
    private String name;

    public University(String name) {
        this.name = name;
    }

    class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayDepartmentInfo() {
            System.out.println("University: " + University.this.name + ", Department: " + deptName);
        }
    }

    static class ExamCell {
        public static void conductExam(String subject) {
            System.out.println("Conducting exam for: " + subject);
        }

        public static void announceResults(String session) {
            System.out.println("Announcing results for: " + session);
        }
    }
}