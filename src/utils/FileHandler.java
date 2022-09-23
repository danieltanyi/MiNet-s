package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<Task> loadFromFile() throws IOException, ClassNotFoundException {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data.txt"));
            List<Task> loadedTasks = (List<Task>) in.readObject();
            return loadedTasks;
        }
        catch (EOFException e){
            System.out.println("File is empty. First thing you need to do is create a task!");
        }
        catch (FileNotFoundException e){
            List<Task> list = new ArrayList<Task>();
            saveToFile(list);

        }
        //return null;
        return loadFromFile();

    }
    public void saveToFile(List<Task> tasksToSave) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data.txt"));
        out.writeObject(tasksToSave);

        System.out.println("TASKS SAVED:");
        System.out.println();
        tasksToSave.forEach(task -> System.out.println("* " + task.getTitle())
        );
    }

}
