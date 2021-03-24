package edu.zc.oj;

import edu.zc.oj.mapper.UserLoginMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author keep-looking
 * @date 2021/3/24 - 17:52
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserLoginMapperTest{
    @Autowired
    UserLoginMapper userLoginMapper;
    @Test
    public void testLoginLog(){
        userLoginMapper.selectList(null).forEach(System.out::println);
    }
}
