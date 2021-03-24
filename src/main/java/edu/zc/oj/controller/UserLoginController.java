//package edu.zc.oj.controller;
//
//import edu.zc.oj.entity.UserLogin;
//import edu.zc.oj.entity.response.Response;
//import edu.zc.oj.service.UserLoginService;
//import edu.zc.oj.utils.ResultUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
///**
// * @author keep-looking
// * @date 2021/3/24 - 15:39
// */
//@RestController("/user_login")
//@RequiredArgsConstructor
//public class UserLoginController {
//    private final UserLoginService userLoginService;
//    @PostMapping
//    public Response recordLoginInfo(@RequestBody @Valid UserLogin userLogin){
//        final boolean isSuccess = userLoginService.save(userLogin);
//        if(isSuccess){
//            return ResultUtils.success(userLogin);
//        }else {
//            return Response.builder()
//                    .code(200)
//                    .message("select failed")
//                    .build();
//        }
//    }
//}
