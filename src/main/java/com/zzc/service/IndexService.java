package com.zzc.service;

import com.zzc.dao.UserDao;
import com.zzc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @Autowired
    private UserDao userDao;
    public User login(String username, String password){
        User user = userDao.selectByUsername(username);
        if(user!=null&&user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public void changePassword(User user){
      userDao.update(user);
    };
}
