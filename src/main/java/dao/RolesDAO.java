package dao;

import dao.interfaces.MainDAO;
import entity.Roles;

import java.sql.SQLException;
import java.util.List;

public class RolesDAO implements MainDAO<Roles> {
    @Override
    public void addObject(Roles obj) {

    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(Roles obj) {

    }

    @Override
    public Roles getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Roles> getObjects() {
        return null;
    }

    @Override
    public List<Roles> getByItem(Roles obj) {
        return null;
    }
}
