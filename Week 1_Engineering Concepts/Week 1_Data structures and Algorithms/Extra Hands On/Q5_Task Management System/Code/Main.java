public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task("T101", "Design Pattern", "Completed"));
        manager.addTask(new Task("T102", "Algorithm DS", "In Progress"));
        manager.addTask(new Task("T103", "Code Review", "Pending"));

        manager.displayAllTasks();

        Task t = manager.searchTask("T102");
        if (t != null) {
            System.out.println("\nFound: " + t);
        } else {
            System.out.println("\nTask not found.");
        }

        manager.deleteTask("T103");

        manager.displayAllTasks();
    }
}
