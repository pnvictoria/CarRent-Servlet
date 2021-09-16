package entity.mapper;

import entity.Levels;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelsMapper {
    public static Levels mapRow(ResultSet rs) throws SQLException {
        return Levels.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();
    }
}
