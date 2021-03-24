package edu.zc.oj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.security.Timestamp;

/**
 * @author keep-looking
 * @date 2021/3/24 - 14:50
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_login", resultMap = "LoginLog")
public class UserLogin {
    private int id;
    private int userId;
    private Timestamp lastLogin;
    private String lastLoginIp;
    private String lastLoginEquipment;

}
