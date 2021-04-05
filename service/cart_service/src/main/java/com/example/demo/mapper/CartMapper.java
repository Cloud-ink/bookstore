package com.example.demo.mapper;

@Mapper
public interface ShoppingCartMapper {
    List<ShoppingCart> getShoppingCart(int user_id);
    //删除购物车
    int deleteShoppingCart(int user_id,int product_id);
    //添加购物车
    int addShoppingCart(int user_id,int product_id);
    //更新购物车
    int updateShoppingCart(int user_id,int product_id,int cart_num);
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCart implements Serializable {
    private int cart_id;// 购物车id
    private int user_id;
    private int product_id;// 商品id
    private int cart_num;//商品数量
    private boolean cart_checked;// 是否勾选
    private int cart_price;
    private String product_name;// 商品名称
    private String product_image;// 商品图片
    private double product_price; //商品价格
    private int product_stock;// 商品限购数量
}
