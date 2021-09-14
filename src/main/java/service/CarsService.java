package service;

import entity.Cars;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class CarsService implements MainService<Cars> {
    @Override
    public boolean addObject(Cars obj) {
        return false;
    }

    @Override
    public void deleteObject(int id) {

    }

    @Override
    public void updateObject(Cars obj) {

    }

    @Override
    public Cars getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Cars> getObjects() {
        return null;
    }

    @Override
    public List<Cars> getByItem(Cars obj) {
        return null;
    }
}
