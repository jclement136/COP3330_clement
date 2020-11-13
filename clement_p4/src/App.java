import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

// HANDLES USER INTERACTION
// use scanners to call on and modify task item, task list
public class App {

    private static Scanner input = new Scanner(System.in);

    private TaskList list;

    public App() {
        list = new TaskList();
    }

    private void processTaskInfo() {
        while(shouldContinue(askShouldContinue())) {
            TaskItem task = takeTaskInfo();

            storeTaskInfo(task);
        }

        writeTaskInfo();
    }


}
