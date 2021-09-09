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
    public boolean addObject(Users obj) {
        List<Users> byItem = daoUser.getByItem(obj);
        if(byItem.isEmpty()) {
            daoUser.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(Users obj) {

    }

    @Override
    public Users getObjectById(int id) throws SQLException {
        return daoUser.getObjectById(id);
    }

    @Override
    public List<Users> getObjects() {
        return null;
    }

    @Override
    public List<Users> getByItem(Users obj) {
        return null;
    }

    public boolean isUserRegistrated(String login, String password) throws SQLException {
        Users user = getObjectById(1);
        if (login.equals(user.getEmail()) && password.equals(user.getPassword()))
            return true;
        else
            return false;
    }
}
