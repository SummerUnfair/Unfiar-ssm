package com.unfair.service.ServiceImpl;

import com.unfair.api.dto.UserDTO;
import com.unfair.db.dao.UserMapper;
import com.unfair.api.vo.UserVO;
import com.unfair.db.model.User;
import com.unfair.db.model.UserCriteria;
import com.unfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserVO> findAll(UserDTO userDTO) {

        User user = userMapper.selectByPrimaryKey("157c56a55c38430c91a079b25aded021");
        System.out.println(user);
        return new ArrayList<UserVO>();
    }
}
