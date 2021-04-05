package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //用户名是否被注册
    boolean findUserName(String username);
    //注册
    boolean register(String user_name,String user_password);
    //根据用户名查找
    User findUserByUserName(String user_name);

    int deleteById(int id);

    int addUser(User user);

    int insertSelective(User user);

    User updateByKey(int id);

    int updataByPrimarySelective(User user);

    int updateUserById(User user);

    List<User> selectUser();

    List<User> selectUserById(int title);
}

