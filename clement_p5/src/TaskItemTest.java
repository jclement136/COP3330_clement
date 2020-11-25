import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", true);
        assertEquals("first task", item.getTitle());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", true);
        assertEquals("2021-01-01", item.getDueDate());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitleValidDueDate() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "description", "2021-01-01", true));
    }

    @Test
    public void creatingTaskItemFailsWithValidTitleInvalidDueDate() {
        assertThrows(TaskItem.InvalidDueDateException.class, () -> new TaskItem("first task", "description", "2021 01 01", true));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitleInvalidDueDate() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "description", "2021 01 01", true));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", true);
        item.setTitle("new title");
        assertEquals(item.getTitle(), "new title");
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", true);
        assertThrows(TaskItem.InvalidTitleException.class, () -> item.setTitle(""));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", true);
        item.setDueDate("2021-01-02");
        assertEquals(item.getDueDate(), "2021-01-02");
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", true);
        assertThrows(TaskItem.InvalidDueDateException.class, () -> item.setDueDate("2021 01 02"));
    }

}
