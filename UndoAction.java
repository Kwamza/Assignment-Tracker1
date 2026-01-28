public class UndoAction {

    public enum ActionType {
        ADD,
        DELETE,
        EDIT
    }

    private ActionType type;
    private Assignment assignmentBefore;
    private Assignment assignmentAfter;

    public UndoAction(ActionType type,
                      Assignment before,
                      Assignment after) {
        this.type = type;
        this.assignmentBefore = before;
        this.assignmentAfter = after;
    }

    public ActionType getType() {
        return type;
    }

    public Assignment getBefore() {
        return assignmentBefore;
    }

    public Assignment getAfter() {
        return assignmentAfter;
    }
}

