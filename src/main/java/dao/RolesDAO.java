package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Roles;
import entity.Users;
import entity.mapper.RolesMapper;
import entity.mapper.UsersMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO implements MainDAO<Roles> {
    private Connection connection;
    private final String INSERT_ROLE = "INSERT INTO car.roles(id, name) VALUES (?, ?);";
    private final String SELECT_ALL_ROLE = "SELECT id, name FROM car.roles;";
    private final String SELECT_ROLE_BY_ID = "SELECT id, name FROM car.roles WHERE id = ?;";
    private final String UPDATE_ROLE_BY_ID = "";
    private final String DELETE_ROLE_BY_ID = "DELETE FROM car.roles WHERE id = ?;";

    public RolesDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Roles obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_ROLE);
            ps.setLong(1, obj.getId());
            ps.setString(2, obj.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_ROLE_BY_ID);
        ps.setLong(1, id);
    }

    @Override
    public void updateObject(Roles obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_ROLE_BY_ID);
            ps.setLong(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setLong(3, obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Roles getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ROLE_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return RolesMapper.mapRow(rs);
        }
        return Roles.newBuilder().build();
    }

    @Override
    public List<Roles> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ROLE);
        List<Roles> rolesList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            rolesList.add(RolesMapper.mapRow(resultSet));
        }
        return rolesList;
    }

    @Override
    public List<Roles> getByItem(Roles obj) {
        return null;
    }
}
