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
                .setJpg(rs.getString("jsp"))
                .setLevel(
                        Levels.newBuilder()
                                .setId(rs.getInt("id"))
                                .setName(rs.getString("name"))
                                .build())
                .setLabel(
                        Labels.newBuilder()
                                .setId(rs.getInt("id"))
                                .setName(rs.getString("name"))
                                .build())
                .setDesc(rs.getString("desc"))
                .build();
    }
}
