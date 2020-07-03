package com.zh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zh.mybatisplus.bean.User;
import com.zh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhanghao
 * @date 2020/7/3 - 14:58
 */
@SpringBootTest
public class MybatisPlusWrapTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.isNotNull("name").isNotNull("email").ge("age",20);
        userMapper.selectObjs(wrapper).forEach(System.out::println);
    }
}
