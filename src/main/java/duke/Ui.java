package duke;

public class Ui {
    private final String LOGO = " ____        _        \n"
                              + "|  _ \\ _   _| | _____ \n"
                              + "| | | | | | | |/ / _ \\\n"
                              + "| |_| | |_| |   <  __/\n"
                              + "|____/ \\__,_|_|\\_\\___|\n";
    private final String DUKE = "\nDuke:";
    private final String USER = "\nUser:";

    public Ui() {
        printStartUpMessage();
    }

    public void printStartUpMessage() {
        System.out.println("Hello from\n" + LOGO);
    }

    public void printStartInteractionsMessage() {
        System.out.println(DUKE + "Hi, what do you want from me?");
    }

    public void printWaitingUserInput() {
        System.out.print(USER);
    }

    public void printTaskList(TaskList tasks) {
        for (int i = 1; i <= tasks.getSize(); i++) {
            System.out.printf("\t\t%d.%s\n", i, tasks.getTask(i));
        }
        System.out.println("\tNow you have " + tasks.getSize() + " tasks in the list.");
    }

    public void printAddTask(TaskList tasks, Task newTask) {
        System.out.println(DUKE + "\n\tAdded:\n\t\t" + newTask);
        System.out.println("\tNow you have " + tasks.getSize() + " tasks in the list.");
    }

    public void printCompleteTask(Task completedTask) {
        System.out.println(DUKE + "\n\tMarking task as completed:");
        System.out.printf("\t\t%s\n", completedTask);
    }

    public void printDeleteTask(TaskList tasks, Task deletedTask) {
        System.out.println(DUKE + "\n\tRemoving task:");
        System.out.printf("\t\t%s\n", deletedTask);
        System.out.println("\tNow you have " + tasks.getSize() + " tasks in the list.");
    }

    public void printLoadTasks(TaskList tasks) {
        System.out.println(DUKE + "I have loaded your past tasks list!");
        printTaskList(tasks);
    }

    public void printErrorMessage(String message) {
        System.out.println(DUKE);
        System.out.println("\tError: " + message + ".");
    }

    public void printExitMessage() {
        System.out.println(DUKE + "Bye. Have a nice day.");
    }
}