package SprintPlanner.enums;

public enum TaskStatus {
    TODO(1),
    INPROGRESS(2),
    DONE(3);

    TaskStatus(int value) {
        this.value = value;
    }

    int value;
    public int getValue() {
        return value;
    }
}
