    import java.io.*;
    import java.nio.file.Files;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Formatter;

    // ENCAPSULATES LIST DATA
    // * Needs (protected) accessors

    public class TaskList {

        List<TaskItem> list;

        // create new task list
        public TaskList() {
            list = new ArrayList<>();
        }

        // add an item
        public void add(TaskItem task) {
            list.add(task);
        }

        // remove an item
        public void remove(int listOption) {
            int index = listOption - 1;
            if (list.size() <= 0)
            {
                throw new IndexOutOfBoundsException("cannot remove an item since list is empty");
            }
            else
            {
                list.remove(index);
            }
        }

        // view current task list
        public void view() {
            for (int i = 0; i < list.size(); i++) {
                TaskItem task = list.get(i);
                System.out.println(
                    "#" + (i + 1)
                    + " ; " + task.getTitle()
                    + " ; " + task.getDescription()
                    + " ; " + task.getDueDate()
                    + " ; " + task.getCompletionStatus());
            }
        }

        // save current task list to file
        public void write(String filename) {
            try(Formatter output = new Formatter(filename)) {
                for(int i = 0; i < list.size(); i++) {
                    TaskItem task = list.get(i);
                    output.format(
                            "#" + (i + 1) + " ; %s ; %s ; %s ; %s%n",
                            task.getTitle(),
                            task.getDescription(),
                            task.getDueDate(),
                            task.getCompletionStatus());
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Unable to find the file...");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // load current task list
        public void load(File filename) throws IOException {
            try{

                FileInputStream fstream = new FileInputStream(filename);

                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;

                while ((strLine = br.readLine()) != null)   {
                    String[] splitted = strLine.split(" ; "); // here - is used as the delimiter
                }

                in.close();
            } catch (Exception e){
                System.err.println("An error occurred when loading the file." + e.getMessage());
            }
        }

        public int findSize() {
            return list.size();
        }


        // edit title
        public void editTitle(int listOption, String newTitle) {
            int index = listOption - 1;
            TaskItem task = list.get(index);
            task.setTitle(newTitle);
        }

        // edit description
        public void editDescription(int listOption, String newDescription) {
            int index = listOption - 1;
            TaskItem task = list.get(index);
            task.setDescription(newDescription);
        }

        // edit due date
        public void editDueDate(int listOption, String newDueDate) {
            int index = listOption - 1;
            TaskItem task = list.get(index);
            task.setDueDate(newDueDate);
        }

        // mark an item as complete
        public void markComplete(int listOption) {
            int index = listOption - 1;
            TaskItem task = list.get(index);
            task.setCompletionStatus("y");
        }

        // unmark an item as complete
        public void unmarkComplete(int listOption) {
            int index = listOption - 1;
            TaskItem task = list.get(index);
            task.setCompletionStatus("n");
        }

    }
