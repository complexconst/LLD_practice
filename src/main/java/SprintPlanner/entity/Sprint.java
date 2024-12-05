package SprintPlanner.entity;

import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private int id;
    private String name;
    private String description;
    List<Integer> taskIds;
    String startDate;
    String endDate;

    public Sprint(int id, String name, String description, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.taskIds = new ArrayList<>();
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getTasks() {
        return taskIds;
    }

    public void setTasks(List<Integer> tasks) {
        this.taskIds = tasks;
    }

}
