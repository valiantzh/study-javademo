package com.study.lombok.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author valiantzh
 * @version 1.0
 */
@Setter
@Getter
@Builder
public class User {
    private String id;
    private String name;
    private Integer age;
}
