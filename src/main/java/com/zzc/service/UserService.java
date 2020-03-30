package com.zzc.service;

import com.zzc.dao.UserDao;
import com.zzc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void insert(User user){
        userDao.insert(user);
    }
    public List<User> selectAll( ){ return userDao.selectAll( ); }


    public User login(User user){
        User u = userDao.selectByUsername(user.getUsername());
        if(u!=null&&user.getPassword().equals(user.getPassword())){
            return user;
        }
        return null;
    }

}
