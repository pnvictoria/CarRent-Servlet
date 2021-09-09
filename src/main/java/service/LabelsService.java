package service;

import entity.Labels;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class LabelsService implements MainService<Labels>  {
    @Override
    public boolean addObject(Labels obj) {
        return false;
    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(Labels obj) {

    }

    @Override
    public Labels getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Labels> getObjects() {
        return null;
    }

    @Override
    public List<Labels> getByItem(Labels obj) {
        return null;
    }
}
