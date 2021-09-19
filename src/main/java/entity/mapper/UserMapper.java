package entity.mapper;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User mapRow(ResultSet rs) throws SQLException {
        return User.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setSurname(rs.getString("surname"))
                .setSex(rs.getBoolean("sex"))
                .setDate(rs.getString("date"))
                .setEmail(rs.getString("email"))
                .setPassword(rs.getString("password"))
                .setRole(RoleMapper.mapRow(rs))
                .build();
    }
}
