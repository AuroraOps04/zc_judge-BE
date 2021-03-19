package edu.zc.oj.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/18
 */

@Data
public class VerifyAccountExistsForm {
    @NotNull
    private String account;
    @NotNull
    private String accountType;
}
