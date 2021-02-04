package com.unfair.service.impl;

import com.unfair.enumeration.StatusEnum;
import com.unfair.service.MoodService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fenghao
 * @discription
 * @create 2020-08-21 22:42
 */
public class MoodServiceImpl implements MoodService {

    public void boring() {

    }

    public void sad() {

    }

    @Override
    public void moodType() {

        //todo 增加选项 修改枚举类
        switch (StatusEnum.FAIL) {

            //https://www.cnblogs.com/oorx/p/8039630.html
        }
    }
}
