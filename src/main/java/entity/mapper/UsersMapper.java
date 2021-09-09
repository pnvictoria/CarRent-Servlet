package entity.mapper;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper {

    public static User mapRow(ResultSet rs) throws SQLException {
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
        }
        return user;
    }
}
