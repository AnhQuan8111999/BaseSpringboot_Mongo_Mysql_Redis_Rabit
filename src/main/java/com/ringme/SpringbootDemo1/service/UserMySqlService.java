package com.ringme.SpringbootDemo1.service;

import com.ringme.SpringbootDemo1.entity.mySql.UserMySql;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserMySqlService {
    List<UserMySql> getAll();

    void creteUser(UserMySql userMySql);

    void updateUser(UserMySql userMySql);

    void deleteUser(long id);

    UserMySql getById(long Id);

    UserMySql getByUserName(String username);
}
