package com.zzc.dao;

import com.zzc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    void insert(User user);
    void delete(String name);
    void update(User user);
    List<User> selectAll();
    User selectByUsername(String username);

}
