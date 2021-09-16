package entity.mapper;

import entity.Labels;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabelsMapper {
    public static Labels mapRow(ResultSet rs) throws SQLException {
        return Labels.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();
    }
}
