package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Users;
import entity.mapper.UsersMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements MainDAO<Users> {
    private Connection connection;
    private final String INSERT_USER = "INSERT INTO car.users(id, name, surname, sex, date, email, password, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String SELECT_ALL_USERS = "SELECT id, name, surname, sex, date, email, password, role_id FROM car.users;";
    private final String SELECT_USER_BY_ID = "SELECT id, name, surname, sex, date, email, password, role_id FROM car.users WHERE id = ?;";
    private final String UPDATE_USER_BY_ID = "UPDATE car.users SET id=?, name=?, surname=?, sex=?, date=?, email=?, password=?, role_id=? WHERE id = ?;";
    private final String DELETE_USER_BY_ID = "DELETE FROM car.users WHERE id = ?;";


    public UsersDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Users obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);
            ps.setLong(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getSurname());
            ps.setBoolean(4, obj.isSex());
            ps.setString(5, obj.getDate());
            ps.setString(6, obj.getEmail());
            ps.setString(7, obj.getPassword());
            ps.setLong(8, obj.getRole().getId());
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
    public void updateObject(Users obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER_BY_ID);
            ps.setLong(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getSurname());
            ps.setBoolean(4, obj.isSex());
            ps.setString(5, obj.getDate());
            ps.setString(6, obj.getEmail());
            ps.setString(7, obj.getPassword());
            ps.setLong(8, obj.getRole().getId());
            ps.setLong(9, obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Users getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return UsersMapper.mapRow(rs);
        }
        return Users.newBuilder().build();
    }

    @Override
    public List<Users> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
        List<Users> usersList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            usersList.add(UsersMapper.mapRow(resultSet));
        }
        return usersList;
    }

    @Override
    public List<Users> getByItem(Users obj) {
        return null;
    }
}
