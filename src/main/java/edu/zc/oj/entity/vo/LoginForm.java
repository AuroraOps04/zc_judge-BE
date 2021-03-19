package edu.zc.oj.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/17
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    @NotNull
    private String account;
    @NotNull
    private String password;
    @NotNull
    private String accountType;
}
