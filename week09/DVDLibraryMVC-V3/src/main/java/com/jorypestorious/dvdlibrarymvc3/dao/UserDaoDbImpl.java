package com.jorypestorious.dvdlibrarymvc3.dao;

import com.jorypestorious.dvdlibrarymvc3.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoDbImpl implements UserDao {

    private static final String SQL_INSERT_USER
            = "INSERT INTO Users (Username, Password, Enabled) VALUES (?, ?, 1)";
    private static final String SQL_INSERT_AUTHORITY
            = "INSERT INTO Authorities (Username, Authority) VALUES (?, ?)";
    private static final String SQL_DELETE_USER
            = "DELETE FROM Users WHERE Username = ?";
    private static final String SQL_DELETE_AUTHORITIES
            = "DELETE FROM Authorities WHERE Username = ?";
    private static final String SQL_GET_ALL_USERS
            = "SELECT Username, Password FROM Users";
    private static final String SQL_GET_AUTHORITIES
            = "SELECT Authority FROM Authorities WHERE Username = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User addUser(User newUser) {
        jdbcTemplate.update(SQL_INSERT_USER, newUser.getUsername(), newUser.getPassword());

        List<String> authorities = newUser.getAuthorities();
        for (String authority : authorities) {
            jdbcTemplate.update(SQL_INSERT_AUTHORITY, newUser.getUsername(), authority);
        }

        return newUser;
    }

    @Override
    public void deleteUser(String username) {
        jdbcTemplate.update(SQL_DELETE_AUTHORITIES, username);
        jdbcTemplate.update(SQL_DELETE_USER, username);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        users = jdbcTemplate.query(SQL_GET_ALL_USERS, new UserMapper());

        for (User u : users) {
            u.setAuthorities(jdbcTemplate.query(SQL_GET_AUTHORITIES, new AuthorityMapper(), u.getUsername()));
        }

        return users;
    }

    private class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int i) throws SQLException {
            User u = new User();
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            return u;
        }
    }

    private class AuthorityMapper implements RowMapper<String> {

        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("authority");
        }
    }
}
