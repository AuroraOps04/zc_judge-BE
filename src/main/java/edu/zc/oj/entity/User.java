package edu.zc.oj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


/**
 * @author keep-looking
 * @date 2021/3/17 - 16:19
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName(value = "user", resultMap = "baseUser")
public class User {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private String studentNo;
    private Boolean isDisable;
    private LocalDateTime createAt;
    private Role role;
    private String avatar;
    private String sessionKey;


}
