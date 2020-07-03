package com.zh.blog.service.impl;

import com.zh.blog.entity.User;
import com.zh.blog.mapper.UserMapper;
import com.zh.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alex
 * @since 2020-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
