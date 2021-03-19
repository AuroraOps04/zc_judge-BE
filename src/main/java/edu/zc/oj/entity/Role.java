package edu.zc.oj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author keep-looking
 * @date 2021/3/17 - 20:42
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Role {
    private Integer id;
    private String name;
}
