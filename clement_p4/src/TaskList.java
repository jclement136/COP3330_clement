import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;
import java.io.FileNotFoundException;

// ENCAPSULATES LIST DATA
// * Needs (protected) accessors

public class TaskList {

    List<TaskItem> list;

    // create new task list
    public TaskList() {
        list = new ArrayList<>();
    }

    // load current task list
    public void load() {
    }

    // view current task list
    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < list.size(); i++) {
                TaskItem task = list.get(i);
                output.format("%s ; %s% ; %s ; %sn", task.getTitle(), task.getDescription(), task.getDueDate(), task.getCompletionStatus());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // save current task list
    public void save() {
    }

    // add an item
    public void add(TaskItem task) {
        list.add(task);
    }

    // edit an item
    public void edit(TaskItem task) {
    }

    // remove an item
    public void remove(TaskItem task) {
    }

    // mark an item as complete
    public void markComplete(TaskItem task) {
    }

    // unmark an item as complete
    public void unmarkComplete(TaskItem task) {
    }

}
