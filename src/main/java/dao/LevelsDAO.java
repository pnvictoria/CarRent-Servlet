package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Levels;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LevelsDAO implements MainDAO<Levels> {
    private Connection connection;
    private final String INSERT_LEVEL = "INSERT INTO car.levels(id, name) VALUES (?, ?);";
    private final String SELECT_ALL_LEVEL = "SELECT id, name FROM car.levels;";
    private final String SELECT_LEVEL_BY_ID = "SELECT id, name FROM car.levels WHERE id = ?;";
    private final String DELETE_LEVEL_BY_ID = "DELETE FROM car.levels WHERE id = ?;";

    public LevelsDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Levels obj) {

    }

    @Override
    public void deleteObject(int id) {

    }

    @Override
    public void updateObject(Levels obj) {

    }

    @Override
    public Levels getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Levels> getObjects() {
        return null;
    }

    @Override
    public List<Levels> getByItem(Levels obj) {
        return null;
    }
}
