package com.unfair.mapper;

import com.unfair.pojo.QueryVo;
import com.unfair.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 用户持久层接口
 */
@Component
public interface UserMapper {

    List<User> findAllTable(Map tables);

    Map<String, Object> getStuAsMapById(Integer id);

    List<Map<String, Object>> getAllStuAsMapById(Integer id);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();

    /**
     * queryUser
     */
    List<User> queryUser(Map map);


    int updateUsr(Map map);

    /**
     * 保存用户
     */
    void saveUser(User user);

    /**
     * 更新用户
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     */
    void deleteUser(Integer userId);
    /**
     * 根据id查询用户信息
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     */
    List<User> findByName(String username);


    /**
     * 查询总用户数
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 分页
     */
    List<User> getUserByLimit(Map<String, Integer> map);

    /**
     * 分页2
     */
    List<User> getUserByBounds();
}
