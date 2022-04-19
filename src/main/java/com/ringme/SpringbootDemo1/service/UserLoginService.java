//package com.ringme.SpringbootDemo1.service;
//
//import com.ringme.SpringbootDemo1.dao.UserMySqlDao;
//import com.ringme.SpringbootDemo1.entity.mySql.UserMySql;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserLoginService implements UserDetailsService {
//
//    @Autowired
//    UserMySqlDao userMySqlDao;
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserMySql userMySql=userMySqlDao.getByUserName(username);
//        if(userMySql == null){
//            throw new UsernameNotFoundException("User does not exit");
//        }else{
//            List<SimpleGrantedAuthority> authorities= new ArrayList<SimpleGrantedAuthority>();
//            authorities.add(new SimpleGrantedAuthority(userMySql.getRole()));
//            UserDetails userDetails= new User(userMySql.getUsername(),userMySql.getPassword(),true,true,true,true,authorities);
//
//            return userDetails;
//        }
//    }
//}
