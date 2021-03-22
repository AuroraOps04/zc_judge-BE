package edu.zc.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import edu.zc.oj.entity.User;
import edu.zc.oj.entity.vo.LoginVo;
import edu.zc.oj.entity.vo.RegisterForm;
import edu.zc.oj.mapper.UserMapper;
import edu.zc.oj.service.UserService;
import edu.zc.oj.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/17
 */

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findByAccount(String account, String accountType) {
        return this.baseMapper.findByAccount(account, accountType);
    }

    @Override
    public LoginVo login(String account, String accountType, String password) {
        final User user = this.baseMapper.login(account, accountType, JWTUtils.encode(password));
        String token;
        try {
            token = JWTUtils.getToken(user);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            token = null;
        }
        return LoginVo
                .builder()
                .token(token)
                .user(user)
                .build();
    }

    @Override
    public User register(RegisterForm form) {
        form.setPassword(JWTUtils.encode(form.getPassword()));
       if( this.baseMapper.register(form) <= 0){
           return null;
       }
        return this.baseMapper.selectById(form.getId());
    }
}
