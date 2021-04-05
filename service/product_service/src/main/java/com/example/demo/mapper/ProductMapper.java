package com.example.demo.mapper;

import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> selectProduct();

    int insert(Product record);

    int insertSelective(Product record);

    int deleteByPrimaryKey(Long product_id);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Product record);

    int updateByPrimaryKeySelective(Product record);
    //查询商品分类列表
    List<Category> getCategoryList();

    Product selectProductByProductId(int product_id);
    //获取轮播图列表
    List<Carousel> getCarouselList();
    //根据分类名获取商品
    List<Product> getProductListByCategoryName(String category_name);
    //根据分类id获取商品
    List<Product> getProductListByCategoryId(int category_id);
    //根据搜索获取商品
    List<Product> getProductListBySearch(String search);
}
