package com.simple.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.pojo.HdkDouhuo;
import com.simple.pojo.HdkGaoyong;
import com.simple.service.DouhuoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-15 15:17
 **/
@Slf4j
@Service
public class DouhuoServiceImpl implements DouhuoService {
    private static String apikey = "xiaozhixiang";
    @Resource
    RestTemplate restTemplate;

    @Override
    public List<HdkDouhuo> getDouhuo(Integer catId, Integer curPage, Integer pageSize) {
        String targetUrl = "http://v2.api.haodanku.com/get_trill_data/apikey/xiaozhixiang/min_id/1/back/10/cat_id/1";
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<>();
        acceptableMediaTypes.add(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        headers.setAccept(acceptableMediaTypes);
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
            String data = response.getBody();
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            JsonNode jsonNode = mapper.readTree(data);
            String code = String.valueOf(jsonNode.get("code"));
            String msg = String.valueOf(jsonNode.get("msg"));
            if (!("1".equals(code))) {
                log.error("好单库抖券商品查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkDouhuo> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkDouhuo>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库抖券商品查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库抖券商品查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }

    /**
     * @return
     * @exception:
     * @DESP: 商品类目：
     * 0全部，1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物
     * 每页返回条数（请在1,2,5,10,20,50,100中选择一个数值返回）
     * @Date: 2020/6/16 cai
     */
    @Override
    public List<HdkGaoyong> getGaoyong(Integer order, Integer curPage, Integer pageSize) {
        StringBuilder sb = new StringBuilder("http://v2.api.haodanku.com/get_highitems/apikey/");
        sb.append(apikey).append("/min_id/").append(curPage).append("/back/").append(pageSize).append("/cat_id/").append(order);
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<>();
        acceptableMediaTypes.add(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        headers.setAccept(acceptableMediaTypes);
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(sb.toString(), String.class);
            String data = response.getBody();
            System.out.println(data);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            JsonNode jsonNode = mapper.readTree(data);
            String code = String.valueOf(jsonNode.get("code"));
            String msg = String.valueOf(jsonNode.get("msg"));
            if (!("200".equals(code))) {
                log.error("好单库高佣商品查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkGaoyong> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkGaoyong>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库高佣商品查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库高佣商品查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }


}
