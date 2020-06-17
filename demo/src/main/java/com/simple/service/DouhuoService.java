package com.simple.service;

import com.simple.pojo.HdkDouhuo;
import com.simple.pojo.HdkGaoyong;

import java.util.List;

public interface DouhuoService {

    List<HdkDouhuo> getDouhuo(Integer catId, Integer curPage, Integer pageSize);

    List<HdkGaoyong> getGaoyong(Integer order, Integer curPage, Integer pageSize);
}
