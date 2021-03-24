package edu.zc.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zc.oj.entity.Problem;
import edu.zc.oj.mapper.ProblemMapper;
import edu.zc.oj.service.ProblemService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/23
 */

@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService  {
}
