package com.geek.optional;

import lombok.Builder;
import lombok.Data;

/**
 * @version V1.0
 * @description: OptionalDTO
 * @author: geek
 * @date 2022/10/12
 **/
@Data
@Builder
public class OptionalDTO {
    private String id;
    private String name;
    private String content;
}
