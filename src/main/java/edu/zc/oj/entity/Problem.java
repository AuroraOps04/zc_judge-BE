package edu.zc.oj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "problem", resultMap = "baseProblem")
public class Problem {
    private Integer id;
    private String title;
    private String inputDescription;
    private String outputDescription;
    private String samples;
    private String hint;
    private String languages;
    private String template;
    private Timestamp createAt;
    private Timestamp updateAt;
    private Integer timeLimit;
    private Integer memoryLimit;
    private Boolean visible;
    // TODO 改成枚举
    private String difficulty;

    private Boolean shareSubmission;
    private BigInteger submissionNumber;
    private BigInteger acceptedNumber;
    private Boolean isPublic;
    private String type;
    private User owner;

    private List<Tag> tags;

}
