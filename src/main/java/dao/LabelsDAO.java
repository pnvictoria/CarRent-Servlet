package dao;

import dao.interfaces.MainDAO;
import entity.Labels;

import java.sql.SQLException;
import java.util.List;

public class LabelsDAO implements MainDAO<Labels> {
    @Override
    public void addObject(Labels obj) {

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
