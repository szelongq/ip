import java.util.ArrayList;

public class Ui {
    private final String logo = " ____        _        \n"
                              + "|  _ \\ _   _| | _____ \n"
                              + "| | | | | | | |/ / _ \\\n"
                              + "| |_| | |_| |   <  __/\n"
                              + "|____/ \\__,_|_|\\_\\___|\n";
    private final String DUKE = "\nDuke:";
    private final String USER = "\nUser:";

    public Ui() {
        startUpMessage();
    }

    public void startUpMessage() {
        System.out.println("Hello from\n" + logo);
    }

    public void startInteractionsMessage() {
        System.out.println(DUKE + "Hi, what do you want from me?");
    }

    public void waitUserInput() {
        System.out.print(USER);
    }

    public void printListTasks(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++)
            System.out.printf("\t\t%d.%s\n", i + 1, tasks.get(i));
        System.out.println("\tNow you have " + tasks.size() + " tasks in the list.");
    }

    public void printAddTask(ArrayList<Task> tasks, Task newTask) {
        System.out.println(DUKE + "\n\tAdded:\n\t\t" + newTask);
        System.out.println("\tNow you have " + tasks.size() + " tasks in the list.");
    }

    public void printCompleteTask(Task completedTask) {
        System.out.println(DUKE + "\n\tMarking task as completed:");
        System.out.printf("\t\t%s\n", completedTask);
    }

    public void printDeleteTask(ArrayList<Task> tasks, Task deletedTask) {
        System.out.println(DUKE + "\n\tRemoving task:");
        System.out.printf("\t\t%s\n", deletedTask);
        System.out.println("\tNow you have " + tasks.size() + " tasks in the list.");
    }

    public void printLoadTasks(ArrayList<Task> tasks) {
        System.out.println(DUKE + "I have loaded your past tasks list!");
        printListTasks(tasks);
    }

    public void printErrorMessage(String message) {
        System.out.println(DUKE);
        System.out.println("\tError: " + message + ".");
    }

    public void exitMessage() {
        System.out.println(DUKE + "Bye. Have a nice day.");
    }
}
