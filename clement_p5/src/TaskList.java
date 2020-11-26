import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TaskList {

    List<TaskItem> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public void add(TaskItem task) {
        list.add(task);
    }

    public void remove(int listOption) {
        int index = listOption - 1;
        if (list.size() <= 0) {
            throw new IndexOutOfBoundsException("Cannot remove an item because the task list is empty.");
        }
        else {
            list.remove(index);
        }
    }

    public int getListSize() {
        return list.size();
    }

    public void view() {
        try {
        TaskItem task;
        System.out.format("Tasks%n%n");
        for (int i = 0; i < list.size(); i++) {
             task = list.get(i);
            System.out.format("[%d]%n", i + 1);
            System.out.println(task.getTitle());
            System.out.println(task.getDescription());
            System.out.println(task.getDueDate());
            if (task.getCompletionStatus())
                System.out.println("Complete");
            else
                System.out.println("Incomplete");
            if (i < list.size())
                System.out.format("%n");
        } }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void save(String filename) {
        try(Formatter output = new Formatter(filename)) {

            output.format("Tasks%n");
            for(TaskItem task : list) {
                output.format("%s%n", task.getTitle());
                output.format("%s%n", task.getDescription());
                output.format("%s%n", task.getDueDate());
                if (task.getCompletionStatus())
                    output.format("Complete%n");
                else
                    output.format("Incomplete%n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void load(String filename) {
        List<TaskItem> backupList = list;
        list = new ArrayList<>();

        try(Scanner input = new Scanner(Paths.get(filename))) {

            String header = input.nextLine();
            if (header.equalsIgnoreCase("tasks")) {
                while(input.hasNext()) {
                    String title = input.nextLine();
                    String description = input.nextLine();
                    String dueDate = input.nextLine();
                    String completionStatus = input.nextLine();

                    boolean complete = false;
                    if (completionStatus.equalsIgnoreCase("incomplete"))
                        complete = false;
                    else if (completionStatus.equalsIgnoreCase("complete"))
                        complete = true;

                    TaskItem task = new TaskItem(title, description, dueDate, complete);
                    list.add(task);
                }
            }
            else {
                list = backupList;
                throw new IllegalArgumentException("Task file not found. No task list loaded.");
            }
        } catch (FileNotFoundException e){
            list = backupList;
            throw new IllegalArgumentException("Task file not found. No task list loaded.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editTitle(int listOption, String newTitle) {
        int index = listOption - 1;
        TaskItem task = list.get(index);
        task.setTitle(newTitle);
    }

    public void editDescription(int listOption, String newDescription) {
        int index = listOption - 1;
        TaskItem task = list.get(index);
        task.setDescription(newDescription);
    }

    public void editDueDate(int listOption, String newDueDate) {
        int index = listOption - 1;
        TaskItem task = list.get(index);
        task.setDueDate(newDueDate);
    }

    public void editCompletionStatus(int listOption, String response) {
        if (response.toLowerCase().startsWith("y"))
            markComplete(listOption);
        else if (response.toLowerCase().startsWith("n"))
            unmarkComplete(listOption);
        else
            throw new IllegalArgumentException("Response must be either y/n.");
    }

    public void markComplete(int listOption) {
        int index = listOption - 1;
        TaskItem task = list.get(index);
        task.setCompletionStatus(true);
    }

    public void unmarkComplete(int listOption) {
        int index = listOption - 1;
        TaskItem task = list.get(index);
        task.setCompletionStatus(false);
    }
}
