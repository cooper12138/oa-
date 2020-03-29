package com.zzc.dao;

public interface LeaveDao {
    void insert();//请假
    void findAll();//查询所有请假信息
    void findById(int id);//根据id查询请假信息
}
