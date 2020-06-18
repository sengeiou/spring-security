package com.simple.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: 高佣商品   该接口返回好单库优质高佣金商品，佣金比例大于40%的天猫单
 * @create: 2020-06-16 14:14
 **/
@Setter
@Getter
public class HdkGaoyong {
    /**
     * 自增ID
     */
    private Long product_id;
    /**
     * 宝贝ID
     */
    private Long itemid;
    /**
     * 宝贝标题
     */
    private String itemtitle;
    /**
     * 宝贝短标题
     */
    private String itemshorttitle;
    /**
     * 宝贝推荐语
     */
    private String itemdesc;
    /**
     * 在售价
     */
    private Double itemprice;
    /**
     * 宝贝月销量
     */
    private Integer itemsale;
    /**
     * 宝贝近2小时跑单
     */
    private Integer itemsale2;
    /**
     * 当天销量
     */
    private Integer todaysale;
    /**
     * 宝贝主图原始图像（由于图片原图过大影响加载速度，建议加上后缀_310x310.jpg，如https://img.alicdn.com/imgextra/i2/3412518427/TB26gs7bb7U5uJjSZFFXXaYHpXa_!!3412518427.jpg_310x310.jpg）
     */
    private String itempic;
    /**
     * 推广长图（带http://img.haodanku.com/0_553757100845_1509175123.jpg-600进行访问）
     */
    private String itempic_copy;
    /**
     * 轮播主图，用英文逗号分隔开来（由于图片原图过大影响加载速度，建议加上后缀_310x310.jpg，如https://img.alicdn.com/imgextra/i2/3412518427/TB26gs7bb7U5uJjSZFFXXaYHpXa_!!3412518427.jpg_310x310.jpg）
     */
    private String taobao_image;
    /**
     * 商品类目：
     * 1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物
     */
    private Integer fqcat;
    /**
     * 宝贝券后价
     */
    private Double itemendprice;
    /**
     * 店铺类型：
     * 天猫店（B）
     * 淘宝店（C）
     */
    private String shoptype;
    /**
     * 优惠券链接
     */
    private String couponurl;
    /**
     * 优惠券金额
     */
    private Double couponmoney;
    /**
     * 是否为品牌产品（1是）
     */
    private Integer is_brand;
    /**
     * 是否为直播（1是）
     */
    private Integer is_live;
    /**
     * 推广导购文案
     */
    private String guide_article;
    /**
     * 商品视频ID（id大于0的为有视频单，视频拼接地址http://cloud.video.taobao.com/play/u/1/p/1/e/6/t/1/+videoid+.mp4）
     */
    private Long videoid;
    /**
     * 活动类型：
     * 普通活动
     * 聚划算
     * 淘抢购
     */
    private String activity_type;
    /**
     * 营销计划链接
     */
    private String planlink;
    /**
     * 店主的userid
     */
    private Long userid;
    /**
     * 店铺掌柜名
     */
    private String sellernick;
    /**
     * 店铺名
     */
    private String shopname;
    /**
     * 佣金计划：
     * 隐藏
     * 营销
     */
    private String tktype;
    /**
     * 佣金比例
     */
    private Double tkrates;
    /**
     * 是否村淘（1是）
     */
    private Integer cuntao;
    /**
     * 预计可得（宝贝价格 * 佣金比例 / 100）
     */
    private Double tkmoney;
    /**
     * 当天优惠券领取量
     */
    private Double couponreceive2;
    /**
     * 优惠券剩余量
     */
    private Double couponsurplus;
    /**
     * 优惠券总数量
     */
    private Double couponnum;
    /**
     * 优惠券使用条件
     */
    private String couponexplain;
    /**
     * 优惠券开始时间
     */
    private Long couponstarttime;
    /**
     * 优惠券结束时间
     */
    private Long couponendtime;
    /**
     * 活动开始时间
     */
    private Long start_time;
    /**
     * 活动结束时间
     */
    private Long end_time;
    /**
     * 发布时间
     */
    private Long starttime;
    /**
     * 举报处理条件
     * 0未举报
     * 1为待处理
     * 2为忽略
     * 3为下架
     */
    private Integer report_status;
    /**
     * 好单指数
     */
    private Integer general_index;
    /**
     * 放单人名号
     */
    private String seller_name;
    /**
     * 折扣力度
     */
    private Double discount;
    /**
     * 双十一定金
     */
    private double deposit;
    /**
     * 双十一定金抵扣金额
     */
    private double deposit_deduct;
    /**
     * 是否包邮商品：1为是
     */
    private Integer is_shipping;

    /**
     * 定向计划佣金比例
     */
    private Double dx_rates;
    /**
     * 定向计划链接
     */
    private String tkurl;
}
