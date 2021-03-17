package edu.zc.oj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author keep-looking
 * @date 2021/3/17 - 16:19
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String studentNo;
    private boolean isDisable;
    private Timestamp createAt;
    private int roleId;
    private String avatar;
    private String sesssionKey;


}
