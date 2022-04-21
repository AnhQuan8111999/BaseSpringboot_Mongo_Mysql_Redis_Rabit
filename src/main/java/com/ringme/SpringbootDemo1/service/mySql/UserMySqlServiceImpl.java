package com.ringme.SpringbootDemo1.service.mySql;

import com.ringme.SpringbootDemo1.dao.UserMySqlDao;
import com.ringme.SpringbootDemo1.entity.mySql.UserMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMySqlServiceImpl implements  UserMySqlService{
    @Autowired
    private UserMySqlDao userMySqlDao;

    @Override
    public List<UserMySql> getAll() {
        List<UserMySql> users=userMySqlDao.getAll();
        return users;
    }

    @Override
    public void creteUser(UserMySql userMySql) {
        userMySqlDao.creteUser(userMySql);
    }

    @Override
    public void updateUser(UserMySql userMySql) {
        userMySqlDao.updateUser(userMySql);
    }

    @Override
    public void deleteUser(long id) {
        userMySqlDao.deleteUser(id);
    }

    @Override
    public UserMySql getById(long Id) {
        return userMySqlDao.getById(Id);
    }

    @Override
    public UserMySql getByUserName(String username) {
        return userMySqlDao.getByUserName(username);
    }
}
