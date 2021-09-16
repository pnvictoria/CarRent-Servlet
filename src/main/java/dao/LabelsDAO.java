package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Labels;
import entity.mapper.LabelsMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabelsDAO implements MainDAO<Labels> {
    private Connection connection;
    private final String INSERT_LABEL = "INSERT INTO car.labels(name) VALUES (?);";
    private final String SELECT_ALL_LABEL = "SELECT id, name FROM car.labels;";
    private final String SELECT_LABEL_BY_ID = "SELECT id, name FROM car.labels WHERE id = ?;";
    private final String UPDATE_LABEL_BY_ID = "UPDATE car.labels SET name=? WHERE id=?;";
    private final String DELETE_LABEL_BY_ID = "DELETE FROM car.labels WHERE id = ?;";

    public LabelsDAO() {
        connection = DataBaseConnection.initialize();
    }

    @Override
    public void addObject(Labels obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_LABEL);
            ps.setString(1, obj.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_LABEL_BY_ID);
        ps.setLong(1, id);
    }

    @Override
    public void updateObject(Labels obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_LABEL_BY_ID);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Labels getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_LABEL_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return LabelsMapper.mapRow(rs);
        }
        return Labels.newBuilder().build();
    }

    @Override
    public List<Labels> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_LABEL);
        List<Labels> labelsList = new ArrayList<>();

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            labelsList.add(LabelsMapper.mapRow(resultSet));
        }
        return labelsList;
    }

    @Override
    public List<Labels> getByItem(Labels obj) {
        return null;
    }
}
