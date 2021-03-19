package edu.zc.oj.controller;

import edu.zc.oj.entity.User;
import edu.zc.oj.entity.response.Response;
import edu.zc.oj.entity.vo.LoginForm;
import edu.zc.oj.entity.vo.LoginVo;
import edu.zc.oj.entity.vo.RegisterForm;
import edu.zc.oj.entity.vo.VerifyAccountExistsForm;
import edu.zc.oj.service.UserService;
import edu.zc.oj.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/17
 */

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public LoginVo login(@RequestBody @Valid LoginForm form) {
        return userService.login(form.getAccount(), form.getAccountType(), form.getPassword());
    }

    @GetMapping("/verifyAccountExists")
    public Boolean verifyAccountExists(@Valid VerifyAccountExistsForm form){
        final User user = userService.findByAccount(form.getAccount(), form.getAccountType());
        return user != null;
    }

    @PostMapping("/register")
    public Response register(@RequestBody @Valid RegisterForm form){
        // 检查用户是否存在
        final User byAccount = userService.findByAccount(form.getAccount(), form.getAccountType());
        final User byEmail = userService.findByAccount(form.getEmail(), "email");
        if(byAccount != null || byEmail != null){
            return Response.builder()
                    .code(200)
                    .message( form.getAccountType() + ": " + form.getAccount() + " 或者email: " + form.getEmail() + "已经存在")
                    .build();
        }
        final User user = userService.register(form);
        if(user == null){
            return new Response(200, "创建用户失败");
        }
        return ResultUtils.insertSuccess(user);
    }


}
