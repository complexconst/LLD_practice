package SprintPlanner.dao;

import SprintPlanner.entity.Sprint;
import SprintPlanner.entity.Task;

public interface SprintDao {
    public void addSprint(Sprint sprint);

    public void addTaskToSprint(Integer sprintId, Integer task);

    public void removeTaskFromSprint(Integer sprintId, Integer ask);
}
