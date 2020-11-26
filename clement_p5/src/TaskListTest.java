import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class TaskListTest {

    // ADD AND REMOVE
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        assertEquals(1, list.getListSize());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        List<TaskItem> list = new ArrayList<>();
        list.add(task);
        list.add(task);
        list.add(task);
        list.remove(task);
        assertEquals(2, list.size());

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        ArrayList<TaskItem> list = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    // FILE MANAGEMENT
    @Test
    public void viewTaskItems() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        assertDoesNotThrow(() -> list.view());
    }

    @Test
    public void newTaskListIsEmpty() {
        ArrayList<TaskItem> list = new ArrayList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);
        list.add(task);

        System.out.println("Current list:");
        list.view();
        System.out.println("Saving file...");
        list.save("output.txt");
        System.out.println("List saved to a file.");
        System.out.println("Loading saved file...");
        list.load("output.txt");
        System.out.println("File loaded. Viewing loaded file...");
        list.view();

        assertEquals(list.getListSize(), 2);
    }

    // GETTING DATA
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        task = list.get(0);
        assertEquals("title", task.getTitle());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        task = list.get(0);
        assertEquals("description", task.getDescription());
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        task = list.get(0);
        assertEquals("2021-01-01", task.getDueDate());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }


// EDITING DATA
    @Test
    public void editingTaskItemChangesValues() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        list.editTitle(1, "new title");
        list.editDescription(1, "new description");
        list.editDueDate(1, "2021-01-02");
        list.markComplete(1);

        assertEquals("new title", task.getTitle());
        assertEquals("new description", task.getDescription());
        assertEquals("2021-01-02", task.getDueDate());
        assertEquals(true, task.getCompletionStatus());
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        list.editTitle(1, "new title");
        assertEquals("new title", task.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.editTitle(2, "new title"));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        list.editDescription(1, "new description");
        assertEquals("new description", task.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.editDescription(2, "new description"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        list.editDueDate(1, "2021-01-02");
        assertEquals("2021-01-02", task.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", true);
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.editDueDate(2, "2021-01-02"));
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", false);
        TaskList list = new TaskList();
        list.add(task);

        list.markComplete(1);
        assertEquals(true, task.getCompletionStatus());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", true);
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.markComplete(2));
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", true);
        TaskList list = new TaskList();
        list.add(task);

        list.unmarkComplete(1);
        assertEquals(false, task.getCompletionStatus());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "description", "2021-01-01", true);
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.unmarkComplete(2));
    }
}