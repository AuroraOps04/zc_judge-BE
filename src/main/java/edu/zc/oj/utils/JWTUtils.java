package edu.zc.oj.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zc.oj.entity.User;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/18
 */

public class JWTUtils {
    private final static String SECRET = "ewGw2LZsEMvEoYy5Ts3VIGm3jPdXsxLub4M3rJtdES2nljhSfWC0ucu27BsQknpZHAlsZQp+mM4BUiVHMo8D7P1Dt4dOgg9JwR7kwKqIdI3HUei2AA62Nc5L9nTNXl6c4OLDh0oPJPPz0DbUJnAeUKRQW8/tAzW53snfr1imZuK0BuPv5f8mgeB5ns509QfUErn";
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final static String SALT = "zc-oj";
    static{
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static String getToken(User user) throws JsonProcessingException {
        return JWT.create()
                .withAudience(OBJECT_MAPPER.writeValueAsString(user)).sign(Algorithm.HMAC256(SECRET));
    }

    public static User getUserFormToken(String token) throws IOException {
        return OBJECT_MAPPER.readValue(JWT.decode(token).getAudience().get(0), User.class);
    }

    public static String encode(String password){
        return DigestUtils.md5DigestAsHex((SALT + password).getBytes());
    }

    public static Boolean verify(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

}
