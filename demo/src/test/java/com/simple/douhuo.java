package com.simple;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.pojo.HdkDouhuo;
import com.simple.pojo.HdkDouyin;
import com.simple.pojo.HdkGaoyong;
import com.simple.pojo.HdkWenhou;
import com.simple.service.DouhuoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-15 15:29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class douhuo {

    @Resource
    DouhuoService douhuoService;

    /**
     * @exception:
     * @DESP: 抖券商品
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test1() {
        List<HdkDouhuo> list = douhuoService.getDouhuo(1, 1, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @exception:
     * @DESP: 高佣商品
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test2() {
        List<HdkGaoyong> list = douhuoService.getGaoyong(1, 1, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @exception:
     * @DESP: 定向计划
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test3() {
        List<HdkGaoyong> list = douhuoService.getDingxiang(1, 1, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @exception:
     * @DESP: 节日板块
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test4() {
        List<HdkGaoyong> list = douhuoService.getJieri(1, 1, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @exception:
     * @DESP: 早晚问候
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test5() {
        List<HdkWenhou> list = douhuoService.getWenhou(1, 1, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @exception:
     * @DESP: 低价包邮
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test6() {
        List<HdkGaoyong> list = douhuoService.getDijiabaoyou(1, 1, 1, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @exception:
     * @DESP: 抖音数据
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test7() {
        List<HdkDouyin> list = douhuoService.getDouyin(596668952682L, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @exception:
     * @DESP: 偏远包邮
     * @Date: 2020/6/16 cai
     */
    @Test
    public void test8() {
        List<HdkGaoyong> list = douhuoService.getPianyuanbaoyou(1,1, 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
