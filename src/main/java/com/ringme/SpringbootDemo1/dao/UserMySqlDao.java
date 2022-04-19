package com.ringme.SpringbootDemo1.dao;

import com.ringme.SpringbootDemo1.entity.mySql.UserMySql;

import java.util.List;

public interface UserMySqlDao {
    List<UserMySql> getAll();

    void creteUser(UserMySql userMySql);

    void updateUser(UserMySql userMySql);

    void deleteUser(long id);

    UserMySql getById(long Id);

    UserMySql getByUserName(String username);
}
