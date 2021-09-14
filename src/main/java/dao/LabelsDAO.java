package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Labels;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LabelsDAO implements MainDAO<Labels> {
    private Connection connection;
    private final String INSERT_LABEL = "INSERT INTO car.label(id, name) VALUES (?, ?);";
    private final String SELECT_ALL_LABEL = "SELECT id, name FROM car.label;";
    private final String SELECT_LABEL_BY_ID = "SELECT id, name FROM car.label WHERE id = ?;";
    private final String DELETE_LABEL_BY_ID = "DELETE FROM car.label WHERE id = ?;";

    public LabelsDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Labels obj) {

    }

    @Override
    public void deleteObject(int id) {

    }

    @Override
    public void updateObject(Labels obj) {

    }

    @Override
    public Labels getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Labels> getObjects() {
        return null;
    }

    @Override
    public List<Labels> getByItem(Labels obj) {
        return null;
    }
}
