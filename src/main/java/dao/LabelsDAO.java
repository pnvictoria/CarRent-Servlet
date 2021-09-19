package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Label;
import entity.mapper.LabelMapper;
import utils.constants.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabelsDAO implements MainDAO<Label> {
    private Connection connection;
    private final String INSERT_LABEL;
    private final String SELECT_ALL_LABEL;
    private final String SELECT_LABEL_BY_ID;
    private final String UPDATE_LABEL_BY_ID ;
    private final String DELETE_LABEL_BY_ID;

    public LabelsDAO() {
        connection = DataBaseConnection.initialize();

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        INSERT_LABEL = propertySql.getSqlProperty("INSERT_LABEL");
        SELECT_ALL_LABEL = propertySql.getSqlProperty("SELECT_ALL_LABEL");
        SELECT_LABEL_BY_ID = propertySql.getSqlProperty("SELECT_LABEL_BY_ID");
        UPDATE_LABEL_BY_ID = propertySql.getSqlProperty("UPDATE_LABEL_BY_ID");
        DELETE_LABEL_BY_ID = propertySql.getSqlProperty("DELETE_LABEL_BY_ID");
    }

    @Override
    public void addObject(Label obj) {
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
    public void updateObject(Label obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_LABEL_BY_ID);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Label getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_LABEL_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return LabelMapper.mapRow(rs);
        }
        return Label.newBuilder().build();
    }

    @Override
    public List<Label> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_LABEL);
        List<Label> labelsList = new ArrayList<>();

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            labelsList.add(LabelMapper.mapRow(resultSet));
        }
        return labelsList;
    }

    @Override
    public List<Label> getByItem(Label obj) {
        return null;
    }
}
