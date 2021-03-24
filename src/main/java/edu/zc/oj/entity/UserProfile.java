package edu.zc.oj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author keep-looking
 * @date 2021/3/17 - 20:43
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_profile", resultMap = "UserProfile")
public class UserProfile {
    private Integer id;
    private Integer userId;
    private String slogan;
    private String github;
    private String blog;
    private String major;
    private String problemStatus;
    private String realName;
    private String college;
}
