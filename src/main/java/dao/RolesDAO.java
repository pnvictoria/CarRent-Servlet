package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Roles;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RolesDAO implements MainDAO<Roles> {
    private Connection connection;
    private final String INSERT_ROLE = "INSERT INTO car.roles(id, name) VALUES (?, ?);";
    private final String SELECT_ALL_ROLE = "SELECT id, name FROM car.roles;";
    private final String SELECT_ROLE_BY_ID = "SELECT id, name FROM car.roles WHERE id = ?;";
    private final String DELETE_ROLE_BY_ID = "DELETE FROM car.roles WHERE id = ?;";

    public RolesDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Roles obj) {

    }

    @Override
    public void deleteObject(int id) {

    }

    @Override
    public void updateObject(Roles obj) {

    }

    @Override
    public Roles getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Roles> getObjects() {
        return null;
    }

    @Override
    public List<Roles> getByItem(Roles obj) {
        return null;
    }
}
