package com.unfair.service.ServiceImpl;

import com.unfair.api.dto.UserDTO;
import com.unfair.db.dao.UserMapper;
import com.unfair.db.model.User;
import com.unfair.db.model.UserCriteria;
import com.unfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fenghao
 * @date 2020/8/21
 * @account 普通用户服务
 */
@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     *
     * @param userDTO 默认为空
     * @return 返回所有用户
     */
    @Override
    public List<User> findAll(UserDTO userDTO) {

        UserCriteria criteria = new UserCriteria();
        List<User> users = userMapper.selectByExample(criteria);
        System.out.println(users);
        return users;
    }
}
