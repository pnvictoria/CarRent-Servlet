package service;

import dao.interfaces.MainDAO;
import entity.Labels;
import entity.Levels;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class LevelsService implements MainService<Levels> {

    private MainDAO<Levels> daoLevels;

    public LevelsService(MainDAO<Levels> daoLabels) {
        this.daoLevels = daoLabels;
    }

    @Override
    public boolean addObject(Levels obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        Levels level = daoLevels.getObjectById(obj.getId());
        if (level == null) {
            daoLevels.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Levels level = daoLevels.getObjectById(id);
        if (level == null)
            daoLevels.deleteObject(id);
    }

    @Override
    public void updateObject(Levels obj) {
        daoLevels.updateObject(obj);
    }

    @Override
    public Levels getObjectById(int id) throws SQLException {
        return daoLevels.getObjectById(id);
    }

    @Override
    public List<Levels> getObjects() throws SQLException {
        return daoLevels.getObjects();
    }

    @Override
    public List<Levels> getByItem(Levels obj) {
        return null;
    }
}
