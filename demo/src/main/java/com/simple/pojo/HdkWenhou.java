package com.simple.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-17 16:17
 **/
@Setter
@Getter
public class HdkWenhou {
    /**问候语图片地址*/
    private String imgsrc;
    /**问候语内容*/
    private String content;
    /**点赞数*/
    private Integer likenum;
    /**分类ID*/
    private Integer categoryid;
}
