package com.zh.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zh.mybatisplus.bean.User;
import com.zh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试插入
     * 可修改主键的生成策略
     */
    @Test
    void test1() {
        User user = new User();
        user.setAge(30);
        user.setEmail("jerry@126.com");
        user.setName("jerry");
        userMapper.insert(user);
    }

    /**
     * 测试修改
     */
    @Test
    void test2() {
        User user = new User();
        user.setId(1278891540021772293L);
        user.setAge(2);
        user.setEmail("dog@126.com");
        user.setName("dog");
        userMapper.updateById(user);
    }

    // 测试乐观锁成功！
    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(1L);
        user.setName("jack");
        user.setEmail("jack.com");
        userMapper.updateById(user);
    }

    // 测试乐观锁失败
    @Test
    public void testOptimisticLocker2(){
        User user = userMapper.selectById(1L);
        user.setName("jack");
        user.setEmail("jack.com");

        User user1 = userMapper.selectById(1L);
        user1.setName("curry");
        user1.setEmail("curry@163.com");
        userMapper.updateById(user1);

        userMapper.updateById(user);
    }

    @Test
    void testselectById(){
        User user = userMapper.selectById(3L);
        System.out.println(user);
    }

    @Test
    void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        users.forEach(System.out::println);
    }

    @Test
    void selectByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","tom");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    void testPage(){
        Page page = new Page(2,3);
        IPage iPage = userMapper.selectPage(page, null);
        iPage.getRecords().forEach(System.out::println);
    }

    @Test
    void testdeleteById(){
        userMapper.deleteById(1278891540021772292L);
    }

    @Test
    void testdeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(1278891540021772290L, 1278891540021772291L, 1278891540021772293L));
    }

    @Test
    void deleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","jack");
        userMapper.deleteByMap(map);
    }

    @Test
    void testlogicDelete(){
        userMapper.deleteById(1278891540021772295L);
    }

}
