package edu.zc.oj.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/18
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {
    // 用来保存插入到数据库后生成的id
    private Integer id;
    @NotNull
    private String account;
    @Email
    private String email;
    @NotNull
    @Length(min = 6, max = 16)
    private String password;
    @NotNull
    private String accountType;
}
