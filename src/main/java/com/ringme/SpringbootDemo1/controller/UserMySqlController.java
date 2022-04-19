package com.ringme.SpringbootDemo1.controller;

import com.ringme.SpringbootDemo1.entity.mySql.UserMySql;
import com.ringme.SpringbootDemo1.service.UserMySqlService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mysql")
public class UserMySqlController {
    private static Logger logger= Logger.getLogger(UserMySqlController.class);
    @Autowired
    UserMySqlService userMySqlService;

    @PostMapping("/adduser")
    public ResponseEntity<?> creatUser(@RequestBody UserMySql userMySqlRs){

        logger.info("logging ");

        UserMySql userMySql=new UserMySql();
        userMySql.setUsername(userMySqlRs.getUsername());
        userMySql.setPassword(userMySqlRs.getPassword());
        userMySql.setDate(userMySqlRs.getDate());
        userMySql.setRole(userMySql.getRole());
        try{
            userMySqlService.creteUser(userMySql);
            return new ResponseEntity<>(userMySql, HttpStatus.OK);
        }catch(Exception e){
            //e.printStackTrace();
            logger.error(e);
            return new ResponseEntity<>("create user unsuccess",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateuser")
    public ResponseEntity<?> editUser(@RequestBody UserMySql userMySqlRs){
        UserMySql userMySql = userMySqlService.getById(userMySqlRs.getId());
        if(userMySql != null){
            userMySql.setUsername(userMySqlRs.getUsername());
            userMySql.setPassword(userMySqlRs.getPassword());
            userMySql.setDate(userMySqlRs.getDate());
            try{
                userMySqlService.updateUser(userMySql);
                return new ResponseEntity<>(userMySql,HttpStatus.OK);
            }catch (Exception e){
                logger.error(e);
                return new ResponseEntity<>("update user unsuccess",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity<>("update user unsuccess",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/deleteuser")
    public ResponseEntity<?> deleteUser(@RequestParam("id") long id){
        UserMySql userMySql = userMySqlService.getById(id);
        if(userMySql !=null){
            try{
                userMySqlService.deleteUser(id);
                return new ResponseEntity<>("Delete user Success",HttpStatus.OK);
            }catch (Exception e){
                logger.error(e);
                return new ResponseEntity<>("Delete user unsuccess",HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity<>("User need delete does not exit ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/view")
    public ResponseEntity<?> getAllUser(){
        List<UserMySql> users=userMySqlService.getAll();
        if(users.size()>0){
            return new ResponseEntity<List<UserMySql>>(users , HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No user",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/viewUserById")
    public ResponseEntity<?> getUserByName(@RequestParam("id") long id){
        try{
            UserMySql userMySql = userMySqlService.getById(id);
            return new ResponseEntity<>(userMySql,HttpStatus.OK);
        }catch(Exception e){
            logger.error(e);
            return new ResponseEntity<>("Find user falise",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/viewUserByName")
    public ResponseEntity<?> getUserByName(@RequestParam("username") String username){
        try{
            UserMySql userMySql = userMySqlService.getByUserName(username);
            return new ResponseEntity<>(userMySql,HttpStatus.OK);
        }catch(Exception e){
            logger.error(e);
            return new ResponseEntity<>("Find user falise",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
