package SprintPlanner;

import SprintPlanner.entity.*;
import SprintPlanner.enums.TaskStatus;

public class Main {
    public static void main(String[] args) {
        SprintPlsnner sprintPlsnner = new SprintPlsnner();
        int globSprintid = 0;

        Sprint sprint = new Sprint(globSprintid++, "nakanf", "akjfnfn", "fjnf", "cknc");
        sprintPlsnner.addSprint(sprint);

        int taskid = 0;

        Task t1 = new Feature(taskid++, "zdvsd","ad", TaskStatus.TODO);
        Task t2 = new Bug(taskid++, "zdvsd","ad", TaskStatus.TODO);

        sprintPlsnner.addTask(0, t1);
        sprintPlsnner.addTask(0, t2);
        User u1 = new User(1);
        User u2 = new User(2);

        sprintPlsnner.assignTask(0, 1);
        sprintPlsnner.assignTask(1, 1);

        sprintPlsnner.changeStatusOfTask(0, TaskStatus.INPROGRESS);
        sprintPlsnner.showTaskAssignedToUser(1);

    }
}
