package edu.zc.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.zc.oj.entity.User;
import edu.zc.oj.entity.vo.LoginVo;
import edu.zc.oj.entity.vo.RegisterForm;
import org.apache.ibatis.annotations.Param;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/17
 */

public interface UserService extends IService<User> {
    /**
     * 查找用户是否存在
     * @param account 用户名
     * @param accountType 用户名类型
     * @return user
     */
    User findByAccount(String account, String accountType);

    /**
     * 根据账号密码登录
     * @param account 用户名
     * @param accountType 用户名类型
     * @param password 密码
     * @return 登录的用户信息
     */
    LoginVo login(String account, String accountType, String password);

    User register(RegisterForm form);
}
