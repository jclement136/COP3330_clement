import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;
import java.io.FileNotFoundException;

public class TaskListTest {

    // ADD AND REMOVE
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);
        // assertEquals(list.length(), 1);
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        List<TaskItem> list = new ArrayList<>();
        assertEquals(0, list.size());
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");

        list.add(task);
        list.add(task);
        list.remove(task);
        assertEquals(1, list.size());

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        List<TaskItem> list = new ArrayList<>();
        assertEquals(0, list.size());
        list.remove(task);

    }


    // EDITING TESTS
    @Test
    public void editingTaskItemChangesValues() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.edit(task);
        assertEquals("y", task.getTitle());
    }


    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.editTitle(task);
        assertEquals("new title", task.getTitle());
    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
    }


    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.editDescription(task);
        assertEquals("new description", task.getDescription());
    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
    }


    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.editDueDate(task);
        assertEquals("2021-01-02", task.getDueDate());
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
    }


    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.markComplete(task);
        assertEquals("y", task.getCompletionStatus());
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "y");
        TaskList list = new TaskList();
        list.unmarkComplete(task);
        assertEquals("n", task.getCompletionStatus());
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
    }


    // GETTING DATA
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
    }


    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
    }


    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
    }


    // TASK LIST FILE FUNCTIONS
    @Test
    public void newTaskListIsEmpty() {
        List<TaskItem> list = new ArrayList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void savedTaskListCanBeLoaded() {

    }
}