package edu.zc.oj;

import edu.zc.oj.mapper.ProblemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author keep-looking
 * @date 2021/3/24 - 15:31
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProblemMapperTest {
    @Autowired
    ProblemMapper problemMapper;
    @Test
    public void testSelect(){
        problemMapper.selectList(null).forEach(System.out::println);
    }
}
