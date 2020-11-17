// ENCAPSULATES ITEM DATA
public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private String completionStatus;

    public TaskItem(String title, String description, String dueDate, String completionStatus) {
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
        setCompletionStatus(completionStatus);
    }

    // SETTERS
    protected void setTitle(String title) {
        if (isTitleValid(title))
        {
            this.title = title;
        }
        else
        {
            throw new InvalidTitleException ("invalid title entered, must be 1 or more characters");
        }
    }
    protected void setDescription(String description) {
        if (isDescriptionValid(description))
        {
            this.description = description;
        }
        else
        {
            throw new InvalidDescriptionException ("invalid description entered, must be 0 or more characters");
        }
    }
    protected void setDueDate(String dueDate) {
        if (isDueDateValid(dueDate))
        {
            this.dueDate = dueDate;
        }
        else
        {
            throw new InvalidDueDateException ("invalid due date entered, must be formatted as YYYY-MM-DD");
        }
    }
    protected void setCompletionStatus(String completionStatus) {
        if (isCompletionStatusValid(completionStatus))
        {
            this.completionStatus = completionStatus;
        }
        else
        {
            throw new InvalidCompletionStatusException ("invalid completion status entered, must be y or n");
        }
    }

    // GETTERS
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

    // VALIDITY
    protected boolean isTitleValid(String title) {
        return (title.length() > 0);
    }
    protected boolean isDescriptionValid(String description) {
        return (description.length() >= 0);
    }
    protected boolean isDueDateValid (String dueDate) {
        // make conditions to check for valid due date - YYYY-MM-DD format <- gotta fix this before the due date validity checker works
        if (dueDate.length() != 10)
            return false;
        else if (dueDate.charAt(4) != '-' || dueDate.charAt(7) != '-') // preliminary hyphen check
            return false;
        else {
            for (int i = 0; i < 10; i++) {

                // check if each char is a digit
                if (Character.isDigit(dueDate.charAt(i))) {

                    // skip past hyphens during digit check
                    if (i == 4 || i == 7) {
                        if (dueDate.charAt(i) == '-')
                            continue;
                        else
                            return false;
                    }

                    // if we reach the end and all conditions have been met, validate
                    if (i == 9)
                        return true;

                    // continue looping for each valid check
                    else
                        continue;
                }
            }
        }
        return false;
    }
    protected boolean isCompletionStatusValid(String completionStatus) {
        return true;
    }


    // EXCEPTIONS
    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }
    class InvalidDescriptionException extends IllegalArgumentException {
        public InvalidDescriptionException(String msg) {
            super(msg);
        }
    }
    class InvalidDueDateException extends IllegalArgumentException {
        public InvalidDueDateException(String msg) {
            super(msg);
        }
    }
    class InvalidCompletionStatusException extends IllegalArgumentException {
        public InvalidCompletionStatusException(String msg) {
            super(msg);
        }
    }
}