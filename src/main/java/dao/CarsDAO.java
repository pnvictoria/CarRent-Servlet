package dao;

import dao.interfaces.MainDAO;
import entity.Cars;

import java.sql.SQLException;
import java.util.List;

public class CarsDAO implements MainDAO<Cars> {

    @Override
    public void addObject(Cars obj) {

    }

    @Override
    public void removeObject(int id) {

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
