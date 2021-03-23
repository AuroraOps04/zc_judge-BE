package edu.zc.oj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.zc.oj.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/23
 */

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 根据问题id获取问题的所有标签
     * @param problemId 问题id
     * @return 标签列表
     */
    List<Tag> getTagsByProblem(Integer problemId);
}
