package com.example.demo.service.impl;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.result.VoPage;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public VoPage searchProduct(int pageNo, int limit, String idSorted) {
        VoPage page = new VoPage();
        List<Product> list = new ArrayList<>();
        list.addAll(productMapper.selectProduct());

        int total = productMapper.selectProduct().size();
        page.setItems(list);
        page.setTotal(total);
//        for(int i = 0;i <= productMapper.selectProduct().size();i++){
//            list.add()
//        }
        return page;
    }

    //前台
    //获取所有商品
    @Override
    public VoPage searchProduct(int pageNo, int limit) {
        VoPage page = new VoPage();
        List<Product> list = new ArrayList<>();
        list.addAll(productMapper.selectProduct());
        int total = productMapper.selectProduct().size();
        page.setItems(list);
        page.setTotal(total);
        return page;
    }
    //获取商品分类
    @Override
    public List<Category> getCategoryList() {
        List<Category> list = new ArrayList<>();
        list.addAll(productMapper.getCategoryList());
        return list;
    }

    @Override
    public Product getProductByProductId(int product_id) {
        return productMapper.selectProductByProductId(product_id);
    }

    @Override
    public List<Carousel> getCarouselList(){
        return productMapper.getCarouselList();
    }

    @Override
    public List<Product> getProductListByCategoryName(String category_name) {
        return productMapper.getProductListByCategoryName(category_name);
    }

    @Override
    public VoPage getProductListByCategoryId(int category_id) {
        VoPage page = new VoPage();
        List<Product> list = new ArrayList<>();
        list.addAll(productMapper.getProductListByCategoryId(category_id));
        int total = productMapper.getProductListByCategoryId(category_id).size();
        page.setItems(list);
        page.setTotal(total);
        return page;
    }

    @Override
    public VoPage getProductListBySearch(String search) {
        VoPage page = new VoPage();
        List<Product> list = new ArrayList<>();
        list.addAll(productMapper.getProductListBySearch(search));
        int total = productMapper.getProductListBySearch(search).size();
        page.setItems(list);
        page.setTotal(total);
        return page;
    }


//    @Override
//    public VoPage searchEmployees(int pageNo, int limit, String idSorted) {
//        VoPage page = null;
//
//        List<VoEmployee> userList = new ArrayList<>();
//        userList.addAll(this.idMaps.values());
//        if(idSorted != null && idSorted.startsWith("-")){
//            Collections.reverse(userList);
//        }
//        int total = userList.size();
//        int maxPageNo = userList.size()%limit == 0? userList.size()/limit:userList.size()/limit + 1;
//        if(pageNo>maxPageNo){
//            pageNo = maxPageNo;
//        }
//        int beginIndex = (pageNo-1)*limit;
//        int endIndex = pageNo*limit;
//        if(endIndex>total){
//            endIndex = total;
//        }
//
//        page = new VoPage(userList.subList(beginIndex, endIndex), total);
//
//        return page;
//    }
}
