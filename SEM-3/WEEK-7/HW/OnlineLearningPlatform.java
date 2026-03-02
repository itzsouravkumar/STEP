public class OnlineLearningPlatform {
    public static void main(String[] args) {
        Course[] courses = new Course[4];
        courses[0] = new VideoCourse("Java Programming", "Alice", "2025-01-15", 80, 120);
        courses[1] = new InteractiveCourse("Web Development", "Bob", "2025-02-01", 90, 3);
        courses[2] = new ReadingCourse("History 101", "Charlie", "2025-03-10", 150, 20);
        courses[3] = new CertificationCourse("AWS Cloud", "Dana", "2025-04-05", 2, true);

        for (Course c : courses) {
            c.displayProgress();
            System.out.println();
        }
    }
}

class Course {
    protected String title;
    protected String instructor;
    protected String enrollmentDate;

    public Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    public void displayProgress() {
        System.out.println("Course: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled On: " + enrollmentDate);
    }
}

class VideoCourse extends Course {
    private int completionPercent;
    private int watchTime; // in minutes

    public VideoCourse(String title, String instructor, String enrollmentDate, int completionPercent, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.completionPercent = completionPercent;
        this.watchTime = watchTime;
    }

    @Override
    public void displayProgress() {
        System.out.println("Video Course Progress:");
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Completion: " + completionPercent + "%");
        System.out.println("Watch Time: " + watchTime + " mins");
    }
}

class InteractiveCourse extends Course {
    private int quizScore;
    private int projectsCompleted;

    public InteractiveCourse(String title, String instructor, String enrollmentDate, int quizScore,
            int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScore = quizScore;
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public void displayProgress() {
        System.out.println("Interactive Course Progress:");
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Quiz Score: " + quizScore + "/100");
        System.out.println("Projects Completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    private int pagesRead;
    private int notesTaken;

    public ReadingCourse(String title, String instructor, String enrollmentDate, int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    @Override
    public void displayProgress() {
        System.out.println("Reading Course Progress:");
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Pages Read: " + pagesRead);
        System.out.println("Notes Taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    private int examAttempts;
    private boolean certified;

    public CertificationCourse(String title, String instructor, String enrollmentDate, int examAttempts,
            boolean certified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certified = certified;
    }

    @Override
    public void displayProgress() {
        System.out.println("Certification Course Progress:");
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Exam Attempts: " + examAttempts);
        System.out.println("Certified: " + (certified ? "Yes" : "No"));
    }
}