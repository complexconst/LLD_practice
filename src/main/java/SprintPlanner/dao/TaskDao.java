package SprintPlanner.dao;

import SprintPlanner.entity.Task;
import SprintPlanner.enums.TaskStatus;

public interface TaskDao {
    public Integer numOfTasksAssignedToUser(Integer userId, TaskStatus... curStatus);
    public void assignTask(Integer taskId, Integer userId);
    public void changeTaskStatus(Integer taskId, TaskStatus newStatus);
    public void addTask(Task task);
    public void removeTask(Integer task);
    Task getTaskById(Integer taskId);

    void showAllTasks(Integer userId);
}
