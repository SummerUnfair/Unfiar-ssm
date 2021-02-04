package com.unfair.service;

import com.unfair.api.dto.LoginInfoDTO;

/**
 * @author fenghao
 * @discription
 * @create 2021-01-23 14:01
 */
public interface LoginService {
    /**
     *  用户是否存在
     * @return
     */
    public String checkUserInfo(LoginInfoDTO dto,String username);

    /**
     *
     */
    public boolean insertUserInfo(LoginInfoDTO dto);
}
