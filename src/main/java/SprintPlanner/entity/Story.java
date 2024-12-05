package SprintPlanner.entity;

import SprintPlanner.enums.TaskStatus;

public class Story extends Task {
    private int id;
    Integer assignedTo;
    String name;
    String description;
    TaskStatus status;

    public Story(int id, String name, String description, TaskStatus status) {
        super(id, name, description, status);
    }
}
