package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Levels;
import entity.Roles;
import entity.mapper.LevelsMapper;
import entity.mapper.RolesMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LevelsDAO implements MainDAO<Levels> {
    private Connection connection;
    private final String INSERT_LEVEL = "INSERT INTO car.levels(name) VALUES (?);";
    private final String SELECT_ALL_LEVEL = "SELECT id, name FROM car.levels;";
    private final String SELECT_LEVEL_BY_ID = "SELECT id, name FROM car.levels WHERE id = ?;";
    private final String UPDATE_LEVEL_BY_ID = "UPDATE car.levels SET name=? WHERE id=?;";
    private final String DELETE_LEVEL_BY_ID = "DELETE FROM car.levels WHERE id = ?;";

    public LevelsDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Levels obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_LEVEL);
            ps.setString(1, obj.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_LEVEL_BY_ID);
        ps.setLong(1, id);
    }

    @Override
    public void updateObject(Levels obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_LEVEL_BY_ID);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Levels getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_LEVEL_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return LevelsMapper.mapRow(rs);
        }
        return Levels.newBuilder().build();
    }

    @Override
    public List<Levels> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_LEVEL);
        List<Levels> levelsList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            levelsList.add(LevelsMapper.mapRow(resultSet));
        }
        return levelsList;
    }

    @Override
    public List<Levels> getByItem(Levels obj) {
        return null;
    }
}