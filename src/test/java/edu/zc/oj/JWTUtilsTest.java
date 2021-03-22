package edu.zc.oj;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zc.oj.entity.User;
import edu.zc.oj.entity.response.Response;
import edu.zc.oj.utils.JWTUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/22
 */

public class JWTUtilsTest {
    @Test
    public void test() throws IOException {
//        try {
//            JWTUtils.getUserFormToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ7XCJpZFwiOjE0OSxcInVzZXJuYW1lXCI6XCJjb2RlcnBsdXNcIixcImVtYWlsXCI6XCI1MjM5NjA0QHFxLmNvbVwiLFwicGhvbmVcIjpudWxsLFwic3R1ZGVudE5vXCI6bnVsbCxcImlzRGlzYWJsZVwiOnRydWUsXCJjcmVhdGVBdFwiOntcIm1vbnRoXCI6XCJNQVJDSFwiLFwieWVhclwiOjIwMjEsXCJkYXlPZk1vbnRoXCI6MjIsXCJkYXlPZldlZWtcIjpcIk1PTkRBWVwiLFwiZGF5T2ZZZWFyXCI6ODEsXCJtb250aFZhbHVlXCI6MyxcImhvdXJcIjoxNSxcIm1pbnV0ZVwiOjAsXCJuYW5vXCI6MCxcInNlY29uZFwiOjU5LFwiY2hyb25vbG9neVwiOntcImlkXCI6XCJJU09cIixcImNhbGVuZGFyVHlwZVwiOlwiaXNvODYwMVwifX0sXCJyb2xlXCI6e1wiaWRcIjoyLFwibmFtZVwiOlwiYWRtaW5cIn0sXCJhdmF0YXJcIjpudWxsLFwic2Vzc2lvbktleVwiOm51bGx9In0.pWQN-nJdKULRB6JuxRGWwBooT5AwqKLxbFSUKcUKUdg");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        System.out.println(JWTUtils.getUserFormToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ7XCJpZFwiOjE0OSxcInVzZXJuYW1lXCI6XCJjb2RlcnBsdXNcIixcImVtYWlsXCI6XCI1MjM5NjA0QHFxLmNvbVwiLFwicGhvbmVcIjpudWxsLFwic3R1ZGVudE5vXCI6bnVsbCxcImlzRGlzYWJsZVwiOnRydWUsXCJjcmVhdGVBdFwiOlwiMjAyMS0wMy0yMiAxNTowMDo1OVwiLFwicm9sZVwiOntcImlkXCI6MixcIm5hbWVcIjpcImFkbWluXCJ9LFwiYXZhdGFyXCI6bnVsbCxcInNlc3Npb25LZXlcIjpudWxsfSJ9.Fj9R0cowMq63wdg-3ysxmB-lN9-fYjFGK5HMsTYwmtk"));
    }

    @Test
    public void testDate() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final User user = new User();
        user.setCreateAt(new Timestamp(342342342));
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        final String s = objectMapper.writeValueAsString(user);
        System.out.println(objectMapper.readValue(s, User.class));
    }
}
