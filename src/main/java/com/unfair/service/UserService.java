package com.unfair.service;

import com.unfair.api.dto.UserDTO;
import com.unfair.api.vo.UserVO;

import java.util.List;

public interface UserService {
    public List<UserVO> findAll(UserDTO userDTO);
}
