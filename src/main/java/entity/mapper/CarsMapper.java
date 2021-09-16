package entity.mapper;

import entity.Cars;
import entity.Labels;
import entity.Levels;
import entity.Roles;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarsMapper {
    public static Cars mapRow(ResultSet rs) throws SQLException {
        return Cars.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setPrice(rs.getInt("price"))
                .setJpg(rs.getString("jpg"))
                .setLevel(LevelsMapper.mapRow(rs))
                .setLabel(LabelsMapper.mapRow(rs))
                .setDesc(rs.getString("desc"))
                .build();
    }
}
