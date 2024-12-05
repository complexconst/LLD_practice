package SprintPlanner.dao.Impl;

import SprintPlanner.dao.SprintDao;
import SprintPlanner.entity.Sprint;
import SprintPlanner.entity.Task;

import java.util.HashMap;
import java.util.Map;

public class SprintDaoImpl implements SprintDao {
    Map<Integer, Sprint> sprints;

    public SprintDaoImpl() {
        sprints = new HashMap<Integer, Sprint>();
    }

    public void addSprint(Sprint sprint) {
        if(sprints.size() == 20) {
            throw new RuntimeException("Sprint could not be added as capacity is full");
        }
        sprints.put(sprint.getId(), sprint);
    }

    public void addTaskToSprint(Integer sprintId, Integer taskId) {
        var sprint = sprints.get(sprintId);
        sprint.getTasks().add(taskId);
        sprints.put(sprint.getId(), sprint);
    }

    public void removeTaskFromSprint(Integer sprintId, Integer taskId) {
        var sprint = sprints.get(sprintId);
        sprint.getTasks().remove(taskId);
        sprints.put(sprint.getId(), sprint);
    }
}
