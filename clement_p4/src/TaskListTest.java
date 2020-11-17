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
        List<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");

        list.add(task);
        list.add(task);
        list.add(task);
        assertEquals(3, list.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        List<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");

        list.add(task);
        list.add(task);
        list.add(task);
        list.remove(task);
        list.remove(task);
        assertEquals(1, list.size());

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        List<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    // FILE MANAGEMENT
    @Test
    public void viewTaskItems() {
        ArrayList<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        list.add(task);

        String viewTest = "1. " + task.getTitle() + " " + task.getDescription() + " " + task.getDueDate() + " " + task.getCompletionStatus();

        assertEquals("1. title description 2021-01-01 n", viewTest);
    }

    @Test
    public void newTaskListIsEmpty() {
        List<TaskItem> list = new ArrayList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void savedTaskListCanBeLoaded() {

    }

    // GETTING DATA
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        list.add(task);

        task = list.get(0);
        assertEquals("title", task.getTitle());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        list.add(task);

        task = list.get(0);
        assertEquals("description", task.getDescription());
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        ArrayList<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        list.add(task);

        task = list.get(0);
        assertEquals("2021-01-01", task.getDueDate());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<>();
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }


    // EDITING TESTS
    @Test
    public void editingTaskItemChangesValues() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);

        list.editTitle(1, "new title");
        list.editDescription(1, "new description");
        list.editDueDate(1, "2021-01-02");
        list.markComplete(1);

        assertEquals("new title", task.getTitle());
        assertEquals("new description", task.getDescription());
        assertEquals("2021-01-02", task.getDueDate());
        assertEquals("y", task.getCompletionStatus());
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);

        list.editTitle(1, "new title");
        assertEquals("new title", task.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.editTitle(2, "new title"));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);

        list.editDescription(1, "new description");
        assertEquals("new description", task.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.editDescription(2, "new description"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);

        list.editDueDate(1, "2021-01-02");
        assertEquals("2021-01-02", task.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "y");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.editDueDate(2, "2021-01-02"));
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "n");
        TaskList list = new TaskList();
        list.add(task);

        list.markComplete(1);
        assertEquals("y", task.getCompletionStatus());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "y");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.markComplete(2));
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "y");
        TaskList list = new TaskList();
        list.add(task);

        list.unmarkComplete(1);
        assertEquals("n", task.getCompletionStatus());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", "y");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.unmarkComplete(2));
    }
}