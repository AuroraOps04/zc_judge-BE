package edu.zc.oj.entity;

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
public class UserProfile {
    private Integer id;
    private User user;
    private String slogan;
    private String github;
    private String blog;
    private String major;
    private String problemStatus;
    private String realName;
    private String college;
}
