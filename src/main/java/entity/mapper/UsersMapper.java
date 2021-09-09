package entity.mapper;

import entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper {

    public static Users mapRow(ResultSet rs) throws SQLException {
        Users user = null;
        if (rs.next()) {
            user = Users.newBuilder()
                    .setId(rs.getInt("id"))
                    .build();
        }
        return user;
    }
}
