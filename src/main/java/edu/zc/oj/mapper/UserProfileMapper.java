package edu.zc.oj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.zc.oj.entity.UserProfile;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author 王冰炜
 * @create 2021-03-24 20:16
 */
@Mapper
public interface UserProfileMapper extends BaseMapper<UserProfile> {
}
