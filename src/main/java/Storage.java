import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private Path savePath;

    public Storage(String filepath) {
        savePath = Path.of(System.getProperty("user.dir"), filepath);
    }

    public ArrayList<Task> load() throws LoadingException {
        if (Files.exists(savePath))
            return loadTasks(savePath);
        else {
            try {
                Files.createFile(savePath);
            } catch (IOException e) {
                throw new LoadingException();
            }
            return null;
        }
    }

    private ArrayList<Task> loadTasks(Path savePath) {
        try (BufferedReader reader = Files.newBufferedReader(savePath)) {

            ArrayList<Task> tasks = new ArrayList<>();
            String line = null;
            Scanner saveDataScanner;

            while ((line = reader.readLine()) != null) {
                saveDataScanner = new Scanner(line).useDelimiter(", ");
                String taskType = saveDataScanner.next();
                boolean isTaskDone = saveDataScanner.nextInt() == 1;
                String taskDesc = saveDataScanner.next();

                switch (taskType) {
                    case "T":
                        tasks.add(new ToDo(taskDesc, isTaskDone));
                        break;
                    case "D":
                        tasks.add(new Deadline(taskDesc,
                                LocalDate.parse(saveDataScanner.next()), isTaskDone));
                        break;
                    case "E":
                        tasks.add(new Event(taskDesc,
                                LocalDate.parse(saveDataScanner.next()), isTaskDone));
                        break;
                }
                saveDataScanner.close();
            }
            return tasks;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void saveTasks(ArrayList<Task> tasks, Path savePath) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(savePath);
            for (Task t: tasks) {
                writer.write(t.toSaveFormat() + "\n");
            }
            writer.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
