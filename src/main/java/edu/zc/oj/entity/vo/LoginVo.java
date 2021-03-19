package edu.zc.oj.entity.vo;

import edu.zc.oj.entity.User;
import lombok.*;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/18
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginVo {
    private User user;
    private String token;
}
