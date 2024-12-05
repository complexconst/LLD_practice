package SprintPlanner.dao.Impl;

import SprintPlanner.dao.TaskDao;
import SprintPlanner.entity.Task;
import SprintPlanner.enums.TaskStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TaskDaoImpl implements TaskDao {

    Map<Integer, Task> tasks;

    public TaskDaoImpl() {
        tasks = new HashMap<Integer, Task>();
    }

    public Task getTaskById(Integer id) {
        return tasks.get(id);
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void removeTask(Integer taskId) {
        tasks.remove(taskId);
    }

    public void showAllTasks(Integer userId) {
        for(Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if(entry.getValue().getAssignedTo().equals(userId)) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
    public Integer numOfTasksAssignedToUser(Integer userId, TaskStatus... curStatus) {
        TaskStatus status = curStatus[0];
        int cnt = 0;
        for(Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if(Objects.equals(entry.getValue().getAssignedTo(), userId)) {
                cnt++;
                if(status != null && !status.equals(entry.getValue().getStatus())) {
                    cnt--;
                }
            }
        }
        return cnt;
    }


    public void assignTask(Integer taskId, Integer userId) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist");
        }
        if(numOfTasksAssignedToUser(userId, TaskStatus.INPROGRESS) == 2) {
            throw new IllegalArgumentException("Cant assign task to user as he has already 2 in progress");
        }
        task.setAssignedTo(userId);
        tasks.put(taskId, task);
    }

    public void changeTaskStatus(Integer taskId, TaskStatus newStatus) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist");
        }
        task.setStatus(newStatus);
        tasks.put(taskId, task);
    }

}
