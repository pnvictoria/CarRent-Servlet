package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Cars;
import entity.Users;
import entity.mapper.CarsMapper;
import entity.mapper.UsersMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarsDAO implements MainDAO<Cars> {
    private Connection connection;
    private final String INSERT_CAR = "INSERT INTO car.cars(id, name, price, jpg, level_id, label_id, \"desc\") VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final String SELECT_ALL_CARS = "SELECT id, name, price, jpg, level_id, label_id, \"desc\" FROM car.cars;";
    private final String SELECT_CAR_BY_ID = "SELECT id, name, price, jpg, level_id, label_id, \"desc\" FROM car.cars WHERE id = ?;";
    private final String UPDATE_CAR_BY_ID = "";
    private final String DELETE_CAR_BY_ID = "DELETE FROM car.cars WHERE id = ?;";

    public CarsDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Cars obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CAR);
            ps.setLong(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setLong(3, obj.getPrice());
            ps.setString(4, obj.getJpg());
            ps.setLong(5, obj.getLevel().getId());
            ps.setLong(6, obj.getLabel().getId());
            ps.setString(7, obj.getDesc());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID);
        ps.setLong(1, id);
    }

    @Override
    public void updateObject(Cars obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_BY_ID);
            ps.setLong(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setLong(3, obj.getPrice());
            ps.setString(4, obj.getJpg());
            ps.setLong(5, obj.getLevel().getId());
            ps.setLong(6, obj.getLabel().getId());
            ps.setString(7, obj.getDesc());
            ps.setLong(8, obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Cars getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_CAR_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return CarsMapper.mapRow(rs);
        }
        return Cars.newBuilder().build();
    }

    @Override
    public List<Cars> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CARS);
        List<Cars> carsList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            carsList.add(CarsMapper.mapRow(resultSet));
        }
        return carsList;
    }

    @Override
    public List<Cars> getByItem(Cars obj) {
        return null;
    }
}
