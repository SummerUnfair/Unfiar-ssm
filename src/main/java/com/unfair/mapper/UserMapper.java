package com.unfair.mapper;

import com.unfair.api.dto.UserDTO;
import com.unfair.pojo.QueryVo;
import com.unfair.api.vo.UserVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 用户持久层接口
 */
@Component
public interface UserMapper {

    List<UserVO> findAllTable(Map tables);

    Map<String, Object> getStuAsMapById(Integer id);

    List<Map<String, Object>> getAllStuAsMapById(Integer id);

    /**
     * 查找所有用户
     * @return
     */
    List<UserVO> findAll(UserDTO userDTO);

    /**
     * queryUser
     */
    List<UserVO> queryUser(Map map);


    int updateUsr(Map map);

    /**
     * 保存用户
     */
    void saveUser(UserVO userVO);

    /**
     * 更新用户
     */
    void updateUser(UserVO userVO);

    /**
     * 根据id删除用户
     */
    void deleteUser(Integer userId);
    /**
     * 根据id查询用户信息
     */
    UserVO findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     */
    List<UserVO> findByName(String username);


    /**
     * 查询总用户数
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<UserVO> findUserByVo(QueryVo vo);

    /**
     * 分页
     */
    List<UserVO> getUserByLimit(Map<String, Integer> map);

    /**
     * 分页2
     */
    List<UserVO> getUserByBounds();
}
