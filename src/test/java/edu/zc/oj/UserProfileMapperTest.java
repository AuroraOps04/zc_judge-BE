package edu.zc.oj;

import edu.zc.oj.entity.UserProfile;
import edu.zc.oj.mapper.UserProfileMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王冰炜
 * @create 2021-03-24 20:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserProfileMapperTest {
    @Autowired
    UserProfileMapper userProfileMapper;
    @Test
    public void testUserProfile(){
        userProfileMapper.selectList(null).forEach(System.out::println);
    }
}
