package service;

import dao.interfaces.MainDAO;
import entity.Cars;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class CarsService implements MainService<Cars> {

    private MainDAO<Cars> daoCars;

    public CarsService(MainDAO<Cars> daoCars) {
        this.daoCars = daoCars;
    }

    @Override
    public boolean addObject(Cars obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или логину
        Cars car = daoCars.getObjectById(obj.getId());
        if (car == null) {
            daoCars.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Cars car = daoCars.getObjectById(id);
        if (car == null)
            daoCars.deleteObject(id);
    }

    @Override
    public void updateObject(Cars obj) {
        daoCars.updateObject(obj);
    }

    @Override
    public Cars getObjectById(int id) throws SQLException {
        return daoCars.getObjectById(id);
    }

    @Override
    public List<Cars> getObjects() throws SQLException {
        return daoCars.getObjects();
    }

    @Override
    public List<Cars> getByItem(Cars obj) {
        return null;
    }
}
