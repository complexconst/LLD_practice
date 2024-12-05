package SprintPlanner.service;

import SprintPlanner.dao.Impl.SprintDaoImpl;
import SprintPlanner.dao.SprintDao;
import SprintPlanner.entity.Sprint;

public class SprintService {

    SprintDao sprintDao;


    public SprintService() {
        sprintDao = new SprintDaoImpl();
    }



    public Integer addSprint(Sprint sprint) {
        Integer id = null;
        try {
            sprintDao.addSprint(sprint);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void addTask(Integer sprintId, Integer taskId) {
        try {
            sprintDao.addTaskToSprint(sprintId, taskId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeTask(Integer sprintId, Integer taskId) {
        try {
            sprintDao.removeTaskFromSprint(sprintId, taskId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
