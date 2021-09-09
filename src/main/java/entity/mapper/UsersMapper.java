package entity.mapper;

import entity.Roles;
import entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper {

    public static Users mapRow(ResultSet rs) throws SQLException {
        Users user = null;
        if (rs.next()) {
            user = Users.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setSurname(rs.getString("surname"))
                    .setSex(rs.getBoolean("sex"))
                    .setDate(rs.getString("date"))
                    .setEmail(rs.getString("email"))
                    .setPassword(rs.getString("password"))
                    .setRole(
                            Roles.newBuilder()
                                    .setId(rs.getInt("id"))
                                    .setName(rs.getString("name"))
                                    .build())
                    .build();
        }
        return user;
    }
}
