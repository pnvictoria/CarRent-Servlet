package entity.mapper;

import entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper {
    public static Car mapRow(ResultSet rs) throws SQLException {
        return Car.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setPrice(rs.getInt("price"))
                .setJpg(rs.getString("jpg"))
                .setLevel(LevelMapper.mapRow(rs))
                .setLabel(LabelMapper.mapRow(rs))
                .setDesc(rs.getString("desc"))
                .build();
    }
}
