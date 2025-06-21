public class Main {
    public static void main(String[] args) {
        Student student = new Student("Hari Nayak", "17253", "A");
        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Joshika Patro");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}