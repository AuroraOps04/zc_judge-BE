package edu.zc.oj.controller;

import edu.zc.oj.entity.UserProfile;
import edu.zc.oj.entity.response.Response;
import edu.zc.oj.service.UserProfileService;
import edu.zc.oj.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 王冰炜
 * @create 2021-03-24 20:30
 */

@RestController
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping("/addUserProfile")
    public Response createUserProfile(@RequestBody @Valid UserProfile profile){
        final boolean isSuccess = userProfileService.save(profile);
        if(isSuccess){
            return ResultUtils.insertSuccess(profile);
        }else{
            return Response.builder()
                    .code(200)
                    .message("add user profile failed")
                    .build();
        }
    }
}
