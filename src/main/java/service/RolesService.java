package service;

import entity.Roles;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class RolesService implements MainService<Roles> {
    @Override
    public boolean addObject(Roles obj) {
        return false;
    }

    @Override
    public void deleteObject(int id) {

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
