package edu.zc.oj.controller;

import edu.zc.oj.annotation.TeacherUser;
import edu.zc.oj.entity.Problem;
import edu.zc.oj.entity.response.Response;
import edu.zc.oj.service.ProblemService;
import edu.zc.oj.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/23
 */

@RestController("/problem")
@RequiredArgsConstructor
public class ProblemController {
    private final ProblemService problemService;

    @PostMapping
    @TeacherUser
    public Response createProblem(@RequestBody @Valid Problem problem){
        final boolean isSuccess = problemService.save(problem);
        if(isSuccess){
            return ResultUtils.insertSuccess(problem);
        }else{
            return Response.builder()
                    .code(200)
                    .message("create problem failed")
                    .build();
        }
    }
}
