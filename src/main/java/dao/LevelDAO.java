package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Level;
import entity.mapper.LevelMapper;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LevelDAO implements MainDAO<Level> {
    private Connection connection;
    private final String INSERT_LEVEL;
    private final String SELECT_ALL_LEVEL;
    private final String SELECT_LEVEL_BY_ID;
    private final String UPDATE_LEVEL_BY_ID;
    private final String DELETE_LEVEL_BY_ID;

    public LevelDAO() {
        connection = DataBaseConnection.initialize();

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        INSERT_LEVEL = propertySql.getSqlProperty("INSERT_LEVEL");
        SELECT_ALL_LEVEL = propertySql.getSqlProperty("SELECT_ALL_LEVEL");
        SELECT_LEVEL_BY_ID = propertySql.getSqlProperty("SELECT_LEVEL_BY_ID");
        UPDATE_LEVEL_BY_ID = propertySql.getSqlProperty("UPDATE_LEVEL_BY_ID");
        DELETE_LEVEL_BY_ID = propertySql.getSqlProperty("DELETE_LEVEL_BY_ID");
    }

    @Override
    public void addObject(Level obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_LEVEL);
            ps.setString(1, obj.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_LEVEL_BY_ID);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateObject(Level obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_LEVEL_BY_ID);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Level getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_LEVEL_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return LevelMapper.mapRow(rs);
        }
        return Level.newBuilder().build();
    }

    @Override
    public List<Level> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_LEVEL);
        List<Level> levelsList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            levelsList.add(LevelMapper.mapRow(resultSet));
        }
        return levelsList;
    }

    @Override
    public List<Level> getByItem(Level obj) {
        return null;
    }
}