package com.ringme.SpringbootDemo1.dao;

import com.ringme.SpringbootDemo1.entity.mySql.UserMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserMySqlDaoImpl implements UserMySqlDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<UserMySql> getAll() {
        String sql = "select * from user";
        List<UserMySql> users = jdbcTemplate.query(sql, new Object[]{}, new RowMapper<UserMySql>() {
            @Override
            public UserMySql mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserMySql userMySql = new UserMySql();
                userMySql.setId(rs.getLong("id"));
                userMySql.setUsername(rs.getString("username"));
                userMySql.setPassword(rs.getString("password"));
                userMySql.setDate(rs.getDate("date"));
                userMySql.setRole(rs.getString("role"));
                return userMySql;
            }
        });
        return users;
    }

    @Override
    public void creteUser(UserMySql userMySql) {
        String sql = "INSERT INTO user (username,password,date,role) VALUE (?,?,?,?)";
        jdbcTemplate.update(sql, userMySql.getUsername(), userMySql.getPassword(), userMySql.getDate(),userMySql.getRole());
    }

    @Override
    public void updateUser(UserMySql userMySql) {
        String sql = "UPDATE user SET username=? , password=? , date=? WHERE id=? ";
        jdbcTemplate.update(sql, userMySql.getUsername(), userMySql.getPassword(), userMySql.getDate(), userMySql.getId());
    }

    @Override
    public void deleteUser(long id) {
        String sql = "DELETE FROM user WHERE id=? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public UserMySql getById(long Id) {
        String sql = "SELECT * FROM user WHERE id=?";
        UserMySql userMySql = jdbcTemplate.queryForObject(sql, new Object[]{Id}, new RowMapper<UserMySql>() {
            @Override
            public UserMySql mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserMySql userMySql = new UserMySql();
                userMySql.setId(rs.getLong("id"));
                userMySql.setUsername(rs.getString("username"));
                userMySql.setPassword(rs.getString("password"));
                userMySql.setDate(rs.getDate("date"));
                userMySql.setRole(rs.getString("role"));
                return userMySql;
            }
        });
        return userMySql;
    }

    @Override
    public UserMySql getByUserName(String username) {
        String sql = "SELECT * FROM user WHERE username like ?";
        UserMySql userMySql = jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper<UserMySql>() {
            @Override
            public UserMySql mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserMySql userMySql = new UserMySql();
                userMySql.setId(rs.getLong("id"));
                userMySql.setUsername(rs.getString("username"));
                userMySql.setPassword(rs.getString("password"));
                userMySql.setDate(rs.getDate("date"));
                userMySql.setRole(rs.getString("role"));
                return userMySql;
            }
        });
        return userMySql;
    }
}
