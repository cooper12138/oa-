package com.zzc.entity;

import java.util.ArrayList;
import java.util.List;

//常量类
public class Content {
    //职务
    public static final String POST_STAFF="员工";
    public static final String POST_HR="员工";

    public static List<String> getPosts(){
        List<String> list = new ArrayList<String>();
        list.add(POST_STAFF);
        list.add(POST_HR);
        return list;
    };
}
