package com.bank.system.dao.rowMapper;

import com.bank.system.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setFirstName(resultSet.getString("f_name"));
        user.setLastName(resultSet.getString("l_name"));
        return user;
    }
}
