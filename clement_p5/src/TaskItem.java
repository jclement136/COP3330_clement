public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public TaskItem(String title, String description, String dueDate, boolean completed) {
        if (title.isBlank())
            throw new InvalidTitleException("A task title must be at least 1 character long.");

        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
        setCompletionStatus(completed);
    }

    // SETTERS
    protected void setTitle(String title) {
        if (isTitleValid(title))
            this.title = title;
        else
            throw new InvalidTitleException("Invalid title entered. Must be 1 or more characters.");
    }
    protected void setDescription(String description) {
        if (isDescriptionValid(description))
            this.description = description;
        else
            throw new InvalidDescriptionException ("Invalid description entered. Must be 0 or more characters.");
    }
    protected void setDueDate(String dueDate) {
        if (isDueDateValid(dueDate))
            this.dueDate = dueDate;
        else
            throw new InvalidDueDateException ("Invalid due date entered. Must be formatted as YYYY-MM-DD.");
    }
    protected void setCompletionStatus(boolean completionStatus) {
        if (completionStatus == true)
            this.completed = true;
        else if (completionStatus == false)
            this.completed = false;
        else
            throw new InvalidDueDateException ("Invalid completion status entered. Must be either true/false.");
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
    public boolean getCompletionStatus() {
        return this.completed;
    }

    // VALIDITY
    protected boolean isTitleValid(String title) {
        return (title.length() > 0);
    }
    protected boolean isDescriptionValid(String description) {
        return (description.length() >= 0);
    }
    protected boolean isDueDateValid (String dueDate) {

        // checks for valid date format YYYY-MM-DD
        if (dueDate.length() != 10)
            return false;

        else if (dueDate.charAt(4) != '-' || dueDate.charAt(7) != '-') // preliminary hyphen check
            return false;

        else {
            for (int i = 0; i < 10; i++) {
                // check if each char is a digit
                if (Character.isDigit(dueDate.charAt(i))) {
                    if (i == 4 || i == 7) { // skips hyphens during digit check
                        if (dueDate.charAt(i) == '-')
                            continue;
                        else
                            return false;
                    }
                    if (i == 9) // return true if entire string passes test
                        return true;
                    else // continue looping to check each index
                        continue;
                }
            }
        }

        return false;
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