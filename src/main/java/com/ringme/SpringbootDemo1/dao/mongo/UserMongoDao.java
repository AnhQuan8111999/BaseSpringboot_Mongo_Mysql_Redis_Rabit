package com.ringme.SpringbootDemo1.dao.mongo;

import com.ringme.SpringbootDemo1.entity.mongoDb.UserMongo;

import java.util.List;

public interface UserMongoDao {
    List<UserMongo> getAll();

    void create(UserMongo userMongo);

    void update(UserMongo userMongo);

    void delete(String id);

    UserMongo getbyId(String id);

    UserMongo getbyname(String name);
}
