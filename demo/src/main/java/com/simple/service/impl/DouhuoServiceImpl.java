package com.simple.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.pojo.HdkDouhuo;
import com.simple.pojo.HdkDouyin;
import com.simple.pojo.HdkGaoyong;
import com.simple.pojo.HdkWenhou;
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

    @Override
    public List<HdkGaoyong> getDingxiang(Integer order, Integer curPage, Integer pageSize) {
        StringBuilder sb = new StringBuilder("http://v2.api.haodanku.com/get_orienteeringitems/apikey/");
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
                log.error("好单库定向商品查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkGaoyong> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkGaoyong>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库定向商品查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库定向商品查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }

    @Override
    public List<HdkGaoyong> getJieri(Integer order, Integer curPage, Integer pageSize) {
        StringBuilder sb = new StringBuilder("http://v2.api.haodanku.com/get_activity_data/apikey/");
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
                log.error("好单库节日商品查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkGaoyong> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkGaoyong>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库节日商品查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库节日商品查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }

    /**
     * @exception:
     * @DESP: 每日问候
     * 分类：1.早安问候；2.用餐问候；3.晚安问候；4.群内公告；5.节日问候；6.爆笑段子；7.其他
     * @Date: 2020/6/17 cai
     */
    @Override
    public List<HdkWenhou> getWenhou(Integer category, Integer curPage, Integer pageSize) {
        StringBuilder sb = new StringBuilder("http://v2.api.haodanku.com/get_salutation_data/apikey/");
        sb.append(apikey).append("/min_id/").append(curPage).append("/back/").append(pageSize).append("/category/").append(category);
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
                log.error("好单库每日问候查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkWenhou> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkWenhou>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库每日问候查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库每日问候查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }

    /**
     * @exception:
     * @DESP: 自定义排序 1.综合；2.券后价从高到低；3.券后价从低到高；4.销量从高到低；5.销量价从低到高；（默认是1）
     * 状态，1.精选专区；2. 9.9专区；3. 6.9专区；4. 3.9专区（默认1）
     * @Date: 2020/6/17 cai
     */
    @Override
    public List<HdkGaoyong> getDijiabaoyou(Integer type, Integer order, Integer curPage, Integer pageSize) {
        StringBuilder sb = new StringBuilder("http://v2.api.haodanku.com/low_price_Pinkage_data/apikey/");
        sb.append(apikey).append("/min_id/").append(curPage)
                .append("/back/").append(pageSize)
                .append("/cat_id/").append(order)
                .append("/type/").append(type);
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
            if (!("1".equals(code))) {
                log.error("好单库低价包邮商品查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkGaoyong> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkGaoyong>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库低价包邮商品查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库低价包邮商品查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }

    @Override
    public List<HdkDouyin> getDouyin(Long itemId, Integer curPage) {
        StringBuilder sb = new StringBuilder("http://v2.api.haodanku.com/douyin_items/apikey/");
        sb.append(apikey).append("/min_id/").append(curPage).append("/itemid/").append(itemId);
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
                log.error("好单库低价包邮商品查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkDouyin> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkDouyin>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库低价包邮商品查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库低价包邮商品查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }
    /**
    * @exception:
    * @DESP: 商品类目： 0全部，1女装，2男装，3内衣，4美妆，5配饰，6鞋品，7箱包，8儿童，9母婴，10居家，11美食，12数码，13家电，14其他，15车品，16文体，17宠物
     * 自定义排序 1.综合；2.券后价从高到低；3.券后价从低到高；4.销量从高到低；5.销量价从低到高；（默认是1）
    * @Date: 2020/6/17 cai
    */
    @Override
    public List<HdkGaoyong> getPianyuanbaoyou(Integer order,Integer catId, Integer curPage, Integer pageSize) {
        StringBuilder sb = new StringBuilder("http://v2.api.haodanku.com/get_free_shipping_data/apikey/");
        sb.append(apikey).append("/min_id/").append(curPage)
                .append("/order/").append(order)
                .append("/back/").append(pageSize)
                .append("/cat_id/").append(catId);
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
            if (!("1".equals(code))) {
                log.error("好单库偏远包邮商品查询出错：{}", msg);
                throw new IllegalArgumentException("查询失败/非网络错误:" + msg);
            }
            List<HdkGaoyong> list = mapper.readValue(String.valueOf(jsonNode.get("data")), new TypeReference<List<HdkGaoyong>>() {
            });
            return list;
        } catch (IllegalArgumentException e) {
            log.error("好单库偏远包邮商品查询出错：{}", e.getMessage());
            throw new IllegalArgumentException("查询失败/非网络错误:{}", e);
        } catch (Exception e) {
            log.error("好单库偏远包邮商品查询出错:{}", e.getMessage());
            throw new RestClientException("查询失败/网络错误:{}", e);
        }
    }

    @Override
    public List<HdkGaoyong> getDapai(Integer order, Integer curPage, Integer pageSize) {
        return null;
    }

    @Override
    public List<HdkGaoyong> getBangdan(Integer order, Integer curPage, Integer pageSize) {
        return null;
    }

    @Override
    public List<HdkGaoyong> getDaren(Integer order, Integer curPage, Integer pageSize) {
        return null;
    }


}
