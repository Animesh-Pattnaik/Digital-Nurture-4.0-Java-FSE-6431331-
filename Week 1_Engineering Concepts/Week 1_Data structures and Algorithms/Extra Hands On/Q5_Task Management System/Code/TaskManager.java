public class TaskManager {
    private TaskNode head;

    public TaskManager() {
        head = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + task);
    }

    public Task searchTask(String taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void displayAllTasks() {
        System.out.println("\n=== Task List ===");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(String taskId) {
        TaskNode current = head;
        TaskNode prev = null;

        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Deleted task with ID: " + taskId);
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Task ID " + taskId + " not found.");
    }
}
