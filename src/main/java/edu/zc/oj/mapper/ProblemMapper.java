package edu.zc.oj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.zc.oj.entity.Problem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/23
 */

@Mapper
public interface ProblemMapper  extends BaseMapper<Problem> {
}
