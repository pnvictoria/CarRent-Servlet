package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.User;
import entity.mapper.UserMapper;
import utils.constants.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements MainDAO<User> {
    private Connection connection;
    private final String INSERT_USER;
    private final String SELECT_ALL_USERS;
    private final String SELECT_USER_BY_ID;
    private final String UPDATE_USER_BY_ID;
    private final String DELETE_USER_BY_ID;

    public UsersDAO() {
        connection = DataBaseConnection.initialize();

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        INSERT_USER = propertySql.getSqlProperty("INSERT_USER");
        SELECT_ALL_USERS = propertySql.getSqlProperty("SELECT_ALL_USERS");
        SELECT_USER_BY_ID = propertySql.getSqlProperty("SELECT_USER_BY_ID");
        UPDATE_USER_BY_ID = propertySql.getSqlProperty("UPDATE_USER_BY_ID");
        DELETE_USER_BY_ID = propertySql.getSqlProperty("DELETE_USER_BY_ID");
    }

    @Override
    public void addObject(User obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setBoolean(3, obj.isSex());
            ps.setString(4, obj.getDate());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getPassword());
            ps.setLong(7, obj.getRole().getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_USER_BY_ID);
        ps.setLong(1, id);
    }

    @Override
    public void updateObject(User obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER_BY_ID);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setBoolean(3, obj.isSex());
            ps.setString(4, obj.getDate());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getPassword());
            ps.setLong(7, obj.getRole().getId());
            ps.setLong(8, obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return UserMapper.mapRow(rs);
        }
        return User.newBuilder().build();
    }

    @Override
    public List<User> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
        List<User> usersList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            usersList.add(UserMapper.mapRow(resultSet));
        }
        return usersList;
    }

    @Override
    public List<User> getByItem(User obj) {
        return null;
    }
}
