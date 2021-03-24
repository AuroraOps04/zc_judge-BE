package edu.zc.oj.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zc.oj.entity.UserProfile;
import edu.zc.oj.mapper.UserProfileMapper;
import edu.zc.oj.service.UserProfileService;
import org.springframework.stereotype.Service;

/**
 * @author 王冰炜
 * @create 2021-03-24 20:28
 */

@Service
public class UserProfileServiceImpl extends ServiceImpl<UserProfileMapper, UserProfile> implements UserProfileService {
}
