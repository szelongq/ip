package duke;

import java.util.Scanner;

public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Duke(String filepath) {
        ui = new Ui();
        storage = new Storage(filepath);

        try {
            tasks = new TaskList(storage.load());
            if (tasks.getSize() > 0) {
                ui.printLoadTasks(tasks);
            }
        } catch (DukeException e) {
            ui.printErrorMessage(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.printStartInteractionsMessage();

        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            ui.printWaitingUserInput();
            userInput = scanner.nextLine();

            try {
                executeCommand(userInput);
            } catch (DukeException e) {
                ui.printErrorMessage(e.getMessage());
            }
        } while (true);
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }

    private void executeCommand(String userInput) throws DukeException {
        CommandType commandType = Parser.parseCommandType(userInput);
        switch (commandType) {
        case EXIT:
            ui.printExitMessage();
            System.exit(0);
        case LIST:
            ui.printTaskList(tasks);
            break;
        case ADD_TASK:
            addNewTask(Parser.parseNewTask(userInput));
            break;
        case COMPLETE_TASK:
            completeTask(Parser.parseTaskNum(userInput));
            break;
        case DELETE_TASK:
            deleteTask(Parser.parseTaskNum(userInput));
            break;
        }
    }

    private void addNewTask(Task newTask) {
        tasks.addTask(newTask);
        storage.saveTasks(tasks);
        ui.printAddTask(tasks, newTask);
    }

    private void completeTask(int taskNum) {
        tasks.completeTask(taskNum);
        storage.saveTasks(tasks);
        ui.printCompleteTask(tasks.getTask(taskNum));
    }

    private void deleteTask(int taskNum) {
        Task deletedTask = tasks.deleteTask(taskNum);
        storage.saveTasks(tasks);
        ui.printDeleteTask(tasks, deletedTask);
    }
}