public class TaskItem {

    // ENCAPSULATES ITEM DATA

    private String title;
    private String description;
    private String dueDate;
    private String completionStatus;

    // CREATE TASK ITEM
    public TaskItem(String title, String description, String dueDate, String completionStatus) {

        // set title
        if(isTitleValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("invalid title entered, must be 1 or more char");
        }

        // set description
        if(isDescriptionValid(description)) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("invalid description entered, must be 0 or more char");
        }

        // set due date
        if(isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("invalid due date entered, must formatted as YYYY-MM-DD");
        }

        // set completion status
        if (isCompletionStatusValid(completionStatus)) {
            this.completionStatus = completionStatus;
        } else {
            throw new IllegalArgumentException("invalid completion status entered, must be y or n");
        }

    }

    // SETTERS
    public void setTitle(String newTitle) {
        if (isCompletionStatusValid(completionStatus)) {
            this.title = newTitle;
        } else {
            throw new IllegalArgumentException("invalid completion status entered, must be y or n");
        }
    }

    public void setDescription(String newDescription) {
        if(isDescriptionValid(newDescription)) {
            this.description = newDescription;
        } else {
            throw new IllegalArgumentException("invalid description entered, must be 0 or more char");
        }
    }

    public void setDueDate(String newDueDate) {
        if(isDueDateValid(newDueDate)) {
            this.dueDate = newDueDate;
        } else {
            throw new IllegalArgumentException("invalid due date entered, must formatted as YYYY-MM-DD");
        }
    }

    public void setCompletionStatus(String newCompletionStatus) {
        if (isCompletionStatusValid(newCompletionStatus)) {
            this.completionStatus = newCompletionStatus;
        } else {
            throw new IllegalArgumentException("invalid completion status entered, must be y or n");
        }
    }


    // GETTER FUNCTIONS
    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDueDate() {
        return this.dueDate;
    }
    public String getCompletionStatus() {
        return this.completionStatus;
    }



    // VALIDITY CHECKERS
    protected boolean isTitleValid(String title) {
        return (title.length() > 0);
    }

    protected boolean isDescriptionValid(String description) {
        return description.length() >= 0;
    }

    protected boolean isDueDateValid (String dueDate) {
       return true; // make conditions to check for valid due date - YYYY-MM-DD format
    }

    protected boolean isCompletionStatusValid(String completionStatus) {
        return ((completionStatus == "y") || (completionStatus == "n"));
    }

}