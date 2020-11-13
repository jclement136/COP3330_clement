import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    // creating
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", "y");
        assertEquals("first task", item.getTitle());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", "y");
        assertEquals("2021-01-01", item.getDueDate());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitleValidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "description", "2021-01-01", "y"));
    }


    @Test
    public void creatingTaskItemFailsWithValidTitleInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("first task", "description", "2021 01 01", "y"));
    }


    @Test
    public void creatingTaskItemFailsWithInvalidTitleInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "description", "2021 01 01", "y"));
    }


    // setting
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", "y");
        item.setTitle("title");
        assertEquals(item.getTitle(), "title");
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", "y");
        assertThrows(IllegalArgumentException.class, () -> item.setTitle(""));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", "y");
        item.setDueDate("2000-01-01");
        assertEquals(item.getDueDate(), "2021-01-01");
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem item = new TaskItem("first task", "description", "2021-01-01", "y");
        assertThrows(IllegalArgumentException.class, () -> item.setDueDate("2021 01 01"));
    }

}