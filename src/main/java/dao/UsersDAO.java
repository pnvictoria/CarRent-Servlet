package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.User;
import entity.mapper.UsersMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDAO implements MainDAO<User> {

    private Connection connection;

    private final String INSERT_USER = "INSERT INTO car.\"user\"(\n" +
            "\tid, email, password)\n" +
            "\tVALUES (?, ?, ?);";
    private final String SELECT_ALL_USERS = "SELECT id, email, password\n" +
            "\tFROM car.\"user\";";
    private final String SELECT_USER_BY_ID = "SELECT id, email, password\n" +
            "\tFROM car.\"user\"\n" +
            "\tWHERE id = ?;";
    private final String DELETE_USER = "DELETE FROM car.\"user\"\n" +
            "\tWHERE id = ?;";


    public UsersDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(User obj) {
//        try {
//            PreparedStatement ps = connection.prepareStatement(INSERT_USER);
//            ps.setLong(1, obj.getId());
//            ps.setString(2, obj.getFirstName());
//            ps.setString(3, obj.getLastName());
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(User obj) {

    }

    @Override
    public User getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        return UsersMapper.mapRow(resultSet);
    }

    @Override
    public List<User> getObjects() {
        return null;
    }

    @Override
    public List<User> getByItem(User obj) {
        return null;
    }
}
