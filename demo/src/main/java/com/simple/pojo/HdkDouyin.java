package com.simple.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-17 16:35
 **/
@Setter
@Getter
public class HdkDouyin {
    /**宝贝ID*/
    private Long itemid;
    /**视频地址*/
    private String video_url;
    /**抖音主播粉丝数*/
    private Integer douyin_emcee_fans;
    /**视频喜欢点赞数*/
    private Integer video_like_count;
    /**视频评论数*/
    private Integer video_comment_count;
    /**视频转发数*/
    private Integer video_forward_count;
    /**视频第一帧图片地址（视频缩略图）*/
    private String first_frame;
    /**视频第一动态图*/
    private String  dynamic_image;
    /**视频分享量*/
    private Integer video_share_count;
}
