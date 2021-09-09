package entity.mapper;

import entity.Levels;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelsMapper {
    public static Levels mapRow(ResultSet rs) throws SQLException {
        Levels level = null;
        if (rs.next()) {
            level = Levels.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .build();
        }
        return level;
    }
}
