package com.ringme.SpringbootDemo1.dao.mongo;

import com.ringme.SpringbootDemo1.entity.mongoDb.UserMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserMongoDaoImpl implements UserMongoDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserMongo> getAll() {
        List<UserMongo> list = new ArrayList<>();
        list = mongoTemplate.findAll(UserMongo.class, "user");
        return list;
    }

    @Override
    public void create(UserMongo userMongo) {
        try{
            mongoTemplate.save(userMongo,"user");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserMongo userMongo) {
        mongoTemplate.save(userMongo,"user");
    }

    @Override
    public void delete(String id) {
        UserMongo userMongo=mongoTemplate.findById(id,UserMongo.class,"user");
        mongoTemplate.remove(userMongo);
    }

    @Override
    public UserMongo getbyId(String id) {
        UserMongo userMongo=mongoTemplate.findById(id,UserMongo.class,"user");
        return userMongo;
    }


    @Override
    public UserMongo getbyname(String name) {
        Query query= new Query(Criteria.where("username").is(name));
        try{
            UserMongo userMongo=mongoTemplate.findOne(query,UserMongo.class);
            return userMongo;
        }catch(Exception e){
            e.printStackTrace();
            return  new UserMongo();
        }
    }
}
