package com.study.lombok.gettersetter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @Data 注解在类上， 自动生成setter/getter、equals、canEqual、hashCode、toString方法
 * @ToString(exclude="id")
 * @EqualsAndHashCode(exclude={"id", "shape"})
 * @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
 * @author valiantzh
 * @version 1.0
 */
@Setter
@Getter
@Accessors(chain = true)
public class User {
    private String id;
    private String name;
    private Integer age;
}
