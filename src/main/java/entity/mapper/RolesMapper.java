package entity.mapper;

import entity.Roles;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolesMapper {
    public static Roles mapRow(ResultSet rs) throws SQLException {
        return Roles.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();
    }
}
