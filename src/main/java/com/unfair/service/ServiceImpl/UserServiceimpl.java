package com.unfair.service.ServiceImpl;

import com.unfair.mapper.UserMapper;
import com.unfair.pojo.User;
import com.unfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

}
