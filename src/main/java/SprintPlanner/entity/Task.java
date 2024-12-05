package SprintPlanner.entity;

import SprintPlanner.enums.TaskStatus;

public class Task {
    private int id;
    Integer assignedTo;
    String name;
    String description;
    TaskStatus status;



    public Task(int id, String name, String description, TaskStatus status) {
        this.id = id;
        this.assignedTo = null;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public Integer getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "id: " + id + ", assignedTo: " + assignedTo + ", name: " + name + ", status: " + status;
    }
}
