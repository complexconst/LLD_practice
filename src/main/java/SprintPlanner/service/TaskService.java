package SprintPlanner.service;

import SprintPlanner.dao.Impl.TaskDaoImpl;
import SprintPlanner.dao.TaskDao;
import SprintPlanner.entity.Task;
import SprintPlanner.enums.TaskStatus;

import static java.lang.Math.abs;

public class TaskService {

    TaskDao taskDao;


    public TaskService() {
        this.taskDao = new TaskDaoImpl();
    }

    public void changeStatusOfTask(Integer taskId, TaskStatus newStatus) {
        if(abs(taskDao.getTaskById(taskId).getStatus().getValue() - newStatus.getValue()) == 1) {
            taskDao.changeTaskStatus(taskId, newStatus);
        }
        else {
            System.out.println("can't change status of task as it is not allowsd");
        }
    }

    public void assignTask(Integer taskId, Integer userId) {
        taskDao.assignTask(taskId, userId);
    }

    public void addTask(Task task) {
        taskDao.addTask(task);
    }
    public void removeTask(Integer taskId) {
        taskDao.removeTask(taskId);
    }

    public void showTasksAssignedToUser(Integer userId) {
        taskDao.showAllTasks(userId);
    }
}
