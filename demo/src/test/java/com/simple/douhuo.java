package com.simple;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.pojo.HdkDouhuo;
import com.simple.pojo.HdkGaoyong;
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
    public void test1(){
        List<HdkDouhuo> list = douhuoService.getDouhuo(1,1,1);
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
    public void test2(){
        List<HdkGaoyong> list = douhuoService.getGaoyong(1,1,1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
