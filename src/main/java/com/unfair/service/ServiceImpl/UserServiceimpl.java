package com.unfair.service.ServiceImpl;

import com.unfair.mapper.UserMapper;
import com.unfair.api.vo.UserVO;
import com.unfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserVO> findAll() {
        return userMapper.findAll();
    }

}
