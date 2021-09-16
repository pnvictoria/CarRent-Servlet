package service;

import dao.interfaces.MainDAO;
import entity.Labels;
import entity.Roles;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class LabelsService implements MainService<Labels> {

    private MainDAO<Labels> daoLabels;

    public LabelsService(MainDAO<Labels> daoLabels) {
        this.daoLabels = daoLabels;
    }

    @Override
    public boolean addObject(Labels obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        Labels label = daoLabels.getObjectById(obj.getId());
        if (label == null) {
            daoLabels.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Labels label = daoLabels.getObjectById(id);
        if (label == null)
            daoLabels.deleteObject(id);
    }

    @Override
    public void updateObject(Labels obj) {
        daoLabels.updateObject(obj);
    }

    @Override
    public Labels getObjectById(int id) throws SQLException {
        return daoLabels.getObjectById(id);
    }

    @Override
    public List<Labels> getObjects() throws SQLException {
        return daoLabels.getObjects();
    }

    @Override
    public List<Labels> getByItem(Labels obj) {
        return null;
    }
}
