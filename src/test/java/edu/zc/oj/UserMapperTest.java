package edu.zc.oj;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.zc.oj.entity.User;
import edu.zc.oj.entity.vo.RegisterForm;
import edu.zc.oj.mapper.UserMapper;
import edu.zc.oj.utils.JWTUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author keep-looking
 * @date 2021/3/17 - 16:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testRegister() {
        final Random random = new Random();
        final RegisterForm registerForm =
                RegisterForm.builder()
                        .account("account" + random.nextInt())
                        .email(random.nextInt() + "email@qq.com")
                        .password("pass")
                        .accountType("username")
                        .build();
        System.out.println(registerForm.getId());
        userMapper.register(registerForm);
        System.out.println(registerForm.getId());

    }

    @Test
    public void testSelect(){
        final User user = userMapper.login("account-1500913985", "username", "pass");
        System.out.println(user);
    }

}
