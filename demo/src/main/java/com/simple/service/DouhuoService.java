package com.simple.service;

import com.simple.pojo.HdkDouhuo;
import com.simple.pojo.HdkDouyin;
import com.simple.pojo.HdkGaoyong;
import com.simple.pojo.HdkWenhou;

import java.util.List;

public interface DouhuoService {
    /**
     * 抖货
     */
    List<HdkDouhuo> getDouhuo(Integer catId, Integer curPage, Integer pageSize);

    /**
     * 高佣
     */
    List<HdkGaoyong> getGaoyong(Integer order, Integer curPage, Integer pageSize);

    /**
     * 定向计划
     */
    List<HdkGaoyong> getDingxiang(Integer order, Integer curPage, Integer pageSize);

    /**
     * 节日活动
     */
    List<HdkGaoyong> getJieri(Integer order, Integer curPage, Integer pageSize);

    /**
     * 早晚问候
     */
    List<HdkWenhou> getWenhou(Integer category, Integer curPage, Integer pageSize);

    /**
     * 精选低价包邮
     */
    List<HdkGaoyong> getDijiabaoyou(Integer type, Integer order, Integer curPage, Integer pageSize);

    /**
     * 抖音数据api
     * @return
     */
    List<HdkDouyin> getDouyin(Long itemId, Integer curPage);

    /**
     * 偏远包邮api
     */
    List<HdkGaoyong> getPianyuanbaoyou(Integer order,Integer catId, Integer curPage, Integer pageSize);

    /**
     * 超值大牌
     */
    List<HdkGaoyong> getDapai(Integer order, Integer curPage, Integer pageSize);

    /**
     * 各大榜单
     */
    List<HdkGaoyong> getBangdan(Integer order, Integer curPage, Integer pageSize);

    /**
     * 达人说
     */
    List<HdkGaoyong> getDaren(Integer order, Integer curPage, Integer pageSize);
}
