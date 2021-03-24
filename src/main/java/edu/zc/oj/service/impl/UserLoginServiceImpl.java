package edu.zc.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zc.oj.entity.UserLogin;
import edu.zc.oj.mapper.UserLoginMapper;
import edu.zc.oj.service.UserLoginService;
import org.springframework.stereotype.Service;

/**
 * @author keep-looking
 * @date 2021/3/24 - 15:05
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {

}
