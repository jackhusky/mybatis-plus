package com.zh.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh.mybatisplus.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhanghao
 * @date 2020/7/3 - 9:44
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
