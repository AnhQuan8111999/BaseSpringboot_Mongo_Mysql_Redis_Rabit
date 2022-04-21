package com.ringme.SpringbootDemo1.controller.mongo;

import com.ringme.SpringbootDemo1.dao.mongo.UserMongoDao;
import com.ringme.SpringbootDemo1.entity.mongoDb.UserMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/mongo")
public class UserMongoController {
    @Autowired
    private UserMongoDao userMongoDao;

    @GetMapping("/view")
    public ResponseEntity<?> getAllUserMongo() {
        List<UserMongo> userMongos = userMongoDao.getAll();
        if (userMongos.size() > 0) {
            return new ResponseEntity<List<UserMongo>>(userMongos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No User", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createUserMongo")
    public ResponseEntity<?> createUserMongo(@RequestParam("username") String username,
                                             @RequestParam("password") String password,
                                             @RequestParam("date") String date) {
        UserMongo userMongo = new UserMongo();
        userMongo.setUsername(username);
        userMongo.setPassword(password);
        try {
            userMongo.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            userMongoDao.create(userMongo);
            return new ResponseEntity<>(userMongo, HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<>("sai dinh dang ngay thang", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/updateUserMongo")
    public ResponseEntity<?> updateUser(@RequestParam("id") String id,
                                        @RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam("date") String date) {
        UserMongo userMongo1 = userMongoDao.getbyId(id);
        if (userMongo1 != null) {
            userMongo1.setUsername(username);
            userMongo1.setPassword(password);
            try {
                userMongo1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        } else {
            return new ResponseEntity<>("User not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            userMongoDao.update(userMongo1);
            return new ResponseEntity<>(userMongo1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("update unsucces", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUserMongo1")
    public ResponseEntity<?> updateUser(@RequestBody UserMongo userMongoRs) {
        UserMongo userMongo1 = userMongoDao.getbyId(userMongoRs.getId());
        if (userMongo1 != null) {
            userMongo1.setUsername(userMongoRs.getUsername());
            userMongo1.setPassword(userMongoRs.getPassword());
            userMongo1.setDate(userMongoRs.getDate());

        } else {
            return new ResponseEntity<>("User not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            userMongoDao.update(userMongo1);
            return new ResponseEntity<>(userMongo1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("update unsucces", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deleteUserMongo")
    public ResponseEntity<?> deleteUser(@RequestParam("id") String id) {
        try {
            userMongoDao.delete(id);
            return new ResponseEntity<>("Delete user success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Delete user unsuccess", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
