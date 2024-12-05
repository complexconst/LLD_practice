package SprintPlanner.entity;

import SprintPlanner.enums.TaskStatus;

public class Bug extends Task {
    private int id;
    Integer assignedTo;
    String name;
    String description;
    TaskStatus status;

    public Bug(int id, String name, String description, TaskStatus status) {
        super(id, name, description, status);
    }
}
