package edu.zc.oj.controller;

import edu.zc.oj.annotation.PassToken;
import edu.zc.oj.entity.User;
import edu.zc.oj.entity.response.Response;
import edu.zc.oj.entity.vo.LoginForm;
import edu.zc.oj.entity.vo.LoginVo;
import edu.zc.oj.entity.vo.RegisterForm;
import edu.zc.oj.entity.vo.VerifyAccountExistsForm;
import edu.zc.oj.service.UserService;
import edu.zc.oj.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/17
 */

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    @PassToken
    public LoginVo login(@RequestBody @Valid LoginForm form) {
        return userService.login(form.getAccount(), form.getAccountType(), form.getPassword());
    }

    @GetMapping("/verifyAccountExists")
    @PassToken
    public Boolean verifyAccountExists(@Valid VerifyAccountExistsForm form){
        final User user = userService.findByAccount(form.getAccount(), form.getAccountType());
        return user != null;
    }

    @PostMapping("/register")
    @PassToken
    public Response register(@RequestBody @Valid RegisterForm form){
        // 检查用户是否存在
        if("email".equals(form.getAccountType())){
            return Response.builder()
                    .code(200)
                    .message("the register account type can't be email")
                    .build();
        }
        final User byAccount = userService.findByAccount(form.getAccount(), form.getAccountType());
        final User byEmail = userService.findByAccount(form.getEmail(), "email");
        if(byAccount != null || byEmail != null){
            return Response.builder()
                    .code(200)
                    .message( form.getAccountType() + ": " + form.getAccount() + " or email: " + form.getEmail() + " already exists")
                    .build();
        }
        final User user = userService.register(form);
        if(user == null){
            return new Response(200, "create user failed");
        }
        return ResultUtils.insertSuccess(user);
    }


}
