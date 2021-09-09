package service;

import dao.interfaces.MainDAO;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements MainService<User> {

    private MainDAO<User> daoUser;

    public UserService(MainDAO<User> daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    public boolean addObject(User obj) {
        List<User> byItem = daoUser.getByItem(obj);
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
    public void updateObject(User obj) {

    }

    @Override
    public User getObjectById(int id) throws SQLException {
        return daoUser.getObjectById(id);
    }

    @Override
    public List<User> getObjects() {
        return null;
    }

    @Override
    public List<User> getByItem(User obj) {
        return null;
    }

    public boolean isUserRegistrated(String login, String password) throws SQLException {
        User user = getObjectById(1);
        if (login.equals(user.getEmail()) && password.equals(user.getPassword()))
            return true;
        else
            return false;
    }
}
