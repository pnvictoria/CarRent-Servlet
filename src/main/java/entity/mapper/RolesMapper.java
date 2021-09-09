package entity.mapper;

import entity.Roles;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolesMapper {
    public static Roles mapRow(ResultSet rs) throws SQLException {
        Roles role = null;
        if (rs.next()) {
            role = Roles.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .build();
        }
        return role;
    }
}
