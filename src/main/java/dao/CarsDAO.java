package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Cars;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarsDAO implements MainDAO<Cars> {
    private Connection connection;
    private final String INSERT_CAR = "INSERT INTO car.cars(id, name, price, jpg, level_id, label_id, \"desc\") VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final String SELECT_ALL_CARS = "SELECT id, name, price, jpg, level_id, label_id, \"desc\" FROM car.cars;";
    private final String SELECT_CAR_BY_ID = "SELECT id, name, price, jpg, level_id, label_id, \"desc\" FROM car.cars WHERE id = ?;";
    private final String DELETE_CAR_BY_ID = "DELETE FROM car.cars WHERE id = ?;";

    public CarsDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Cars obj) {

    }

    @Override
    public void deleteObject(int id) {

    }

    @Override
    public void updateObject(Cars obj) {

    }

    @Override
    public Cars getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Cars> getObjects() {
        return null;
    }

    @Override
    public List<Cars> getByItem(Cars obj) {
        return null;
    }
}
