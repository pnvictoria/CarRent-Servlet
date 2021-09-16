package service;

import dao.interfaces.MainDAO;
import entity.Roles;
import entity.Users;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class RolesService implements MainService<Roles> {

    private MainDAO<Roles> daoRoles;

    public RolesService(MainDAO<Roles> daoRoles) {
        this.daoRoles = daoRoles;
    }

    @Override
    public boolean addObject(Roles obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        Roles role = daoRoles.getObjectById(obj.getId());
        if (role == null) {
            daoRoles.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Roles role = daoRoles.getObjectById(id);
        if (role == null)
            daoRoles.deleteObject(id);
    }

    @Override
    public void updateObject(Roles obj) {
        daoRoles.updateObject(obj);
    }

    @Override
    public Roles getObjectById(int id) throws SQLException {
        return daoRoles.getObjectById(id);
    }

    @Override
    public List<Roles> getObjects() throws SQLException {
        return daoRoles.getObjects();
    }

    @Override
    public List<Roles> getByItem(Roles obj) {
        return null;
    }
}
