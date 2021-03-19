package edu.zc.oj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.zc.oj.entity.User;
import edu.zc.oj.entity.vo.RegisterForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author keep-looking
 * @date 2021/3/17 - 16:22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查找用户是否存在
     * @param account 用户名
     * @param accountType 用户名类型
     * @return user
     */
    User findByAccount(@Param("account") String account, @Param("accountType") String accountType);

    /**
     * 根据账号密码登录
     * @param account 用户名
     * @param accountType 用户名类型
     * @param password 密码
     * @return 登录的用户信息
     */
    User login(@Param("account") String account, @Param("accountType") String accountType, @Param("password") String password);

    /**
     * 用户注册
     * @param registerForm 登录需要的数据
     * @return 受影响行数
     */

    Integer register(RegisterForm registerForm);
}
