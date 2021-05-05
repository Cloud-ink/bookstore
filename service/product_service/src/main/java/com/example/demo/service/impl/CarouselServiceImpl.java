package com.example.demo.service.impl;

import com.example.demo.mapper.CarouselMapper;
import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.Product;
import com.example.demo.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    CarouselMapper carouselMapper;

    @Cacheable(value = "index",key = "'listCarousels'")
    @Override
    //获取轮播图列表
    public List<Carousel> listCarousels(){
        List<Carousel> carouselList = carouselMapper.selectList(null);
        return carouselList;
    }
}
