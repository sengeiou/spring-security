package com.simple.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: 好单库抖货
 * @create: 2020-06-15 17:07
 **/
@Setter
@Getter

public class HdkDouhuo {
    /**自增ID*/
    private Long product_id;
    /**宝贝ID*/
    private Long itemid;
    /**放单人ID*/
    private Long seller_id;
    /**宝贝标题*/
    private String itemtitle;
    /**宝贝短标题*/
    private String itemshorttitle;
    /**宝贝推荐语*/
    private String itemdesc;
    /**在售价*/
    private Double itemprice;
    /**宝贝月销量*/
    private Long itemsale;
    /**宝贝近2小时跑单*/
    private Long itemsale2;

    /**当天销量（选择昨日爆单榜没有该字段）*/
    private Long todaysale;
    /**昨日销量（选择昨日爆单榜才有该字段）*/
    private Long yesterdaysale;
    /**宝贝主图原始图像（由于图片原图过大影响加载速度，建议加上后缀_310x310.jpg，如https://img.alicdn.com/imgextra/i2/3412518427/TB26gs7bb7U5uJjSZFFXXaYHpXa_!!3412518427.jpg_310x310.jpg）*/
    private String itempic;
    /**推广长图（带http://img.haodanku.com/0_553757100845_1509175123.jpg-600进行访问）*/
    private String itempic_copy;
    /**商品类目：
     1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物*/
    private String fqcat;
    /**宝贝券后价*/
    private String itemendprice;
    /**店铺类型：天猫（B）淘宝店（C）*/
    private String shoptype;
    /**佣金计划：隐藏  营销*/
    private String tktype;
    /**佣金比例*/
    private String tkrates;
    /**预计可得（宝贝价格 * 佣金比例 / 100）*/
    private String tkmoney;

    /**优惠券链接*/
    private String couponurl;
    /**优惠券金额*/
    private Double couponmoney;
    /**优惠券剩余量*/
    private Integer couponsurplus;
    /**优惠券领取量*/
    private Integer couponreceive;
    /**2小时内优惠券领取量*/
    private Integer couponreceive2;
    /**今日优惠券领取量*/
    private Integer todaycouponreceive;
    /**优惠券总数量*/
    private Integer couponnum;
    /**优惠券使用条件*/
    private String couponexplain;
    /**优惠券开始时间*/
    private Long couponstarttime;
    /**优惠券结束时间*/
    private Long couponendtime;
    /**活动开始时间*/
    private Long start_time;
    /**活动结束时间*/
    private Long end_time;
    /**发布时间*/
    private Long starttime;
    /**是否为品牌产品（1是）*/
    private Integer is_brand	;


    /**推广导购文案*/
    private String guide_article	;
    /**商品视频ID（id大于0的为有视频单，视频拼接地址http://cloud.video.taobao.com/play/u/1/p/1/e/6/t/1/+videoid+.mp4）*/
    private String videoid	;
    /**活动类型：普通活动  聚划算 淘抢购*/
    private String activity_type	;
    /**好单指数*/
    private Integer general_index	;
    /**营销计划链接*/
    private String planlink	;
    /**放单人名号*/
    private String seller_name	;
    /**店铺掌柜名*/
    private String sellernick	;
    /**折扣力度*/
    private Double discount	;
    /**抖音商品ID*/
    private String dy_trill_id	;
    /**抖音视频地址*/
    private String dy_video_url	;
    /**抖音视频点赞数*/
    private Integer dy_video_like_count	;
    /**抖音视频分享量*/
    private Integer dy_video_share_count	;
    /**视频第一帧图片地址*/
    private String first_frame	;
    /**视频缩略图（动态）*/
    private String dynamic_image;
    /**抖音视频标题*/
    private String dy_video_title;


}
