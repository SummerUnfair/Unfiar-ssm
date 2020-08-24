package com.unfair.service;

import com.unfair.api.dto.UserDTO;
import com.unfair.api.vo.UserVO;
import com.unfair.db.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll(UserDTO userDTO);
}
