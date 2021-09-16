package service;

import dao.interfaces.MainDAO;
import entity.Users;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class UsersService implements MainService<Users> {

    private MainDAO<Users> daoUser;

    public UsersService(MainDAO<Users> daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    public boolean addObject(Users obj) throws SQLException {
        //изменить проверку, сделать проверку полностью по обьекту или логину
        Users user = daoUser.getObjectById(obj.getId());
        if (user == null) {
            daoUser.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        Users user = daoUser.getObjectById(id);
        if (user == null)
            daoUser.deleteObject(id);
    }

    @Override
    public void updateObject(Users obj) {
        daoUser.updateObject(obj);
    }

    @Override
    public Users getObjectById(int id) throws SQLException {
        return daoUser.getObjectById(id);
    }

    @Override
    public List<Users> getObjects() throws SQLException {
        return daoUser.getObjects();
    }

    @Override
    public List<Users> getByItem(Users obj) {
        return null;
    }
}
