package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Cars;
import entity.mapper.CarsMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.constants.SqlQueriesConst.*;

public class CarsDAO implements MainDAO<Cars> {
    private Connection connection;
    public CarsDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Cars obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CAR);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getPrice());
            ps.setString(3, obj.getJpg());
            ps.setLong(4, obj.getLevel().getId());
            ps.setLong(5, obj.getLabel().getId());
            ps.setString(6, obj.getDesc());
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
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getPrice());
            ps.setString(3, obj.getJpg());
            ps.setLong(4, obj.getLevel().getId());
            ps.setLong(5, obj.getLabel().getId());
            ps.setString(6, obj.getDesc());
            ps.setLong(7, obj.getId());
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
