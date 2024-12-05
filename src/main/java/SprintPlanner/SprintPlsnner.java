package SprintPlanner;

import SprintPlanner.entity.Sprint;
import SprintPlanner.entity.Task;
import SprintPlanner.enums.TaskStatus;
import SprintPlanner.service.SprintService;
import SprintPlanner.service.TaskService;

public class SprintPlsnner {


    SprintService sprintService = new SprintService();
    TaskService taskService = new TaskService();


    void addSprint(Sprint sprint) {
        sprintService.addSprint(sprint);
    }
    void addTask(Integer sprintId, Task task) {
        sprintService.addTask(sprintId, task.getId());
        taskService.addTask(task);
    }
    void removeTask(Integer sprintId, Integer taskId) {
        sprintService.removeTask(sprintId, taskId);
        taskService.removeTask(taskId);
    }
    void assignTask(Integer taskId, Integer userId) {
        taskService.assignTask(taskId, userId);
    }
    void changeStatusOfTask(Integer taskId, TaskStatus status) {
        taskService.changeStatusOfTask(taskId, status);
    }
    void showTaskAssignedToUser(Integer userId) {
        taskService.showTasksAssignedToUser(userId);
    }

}
