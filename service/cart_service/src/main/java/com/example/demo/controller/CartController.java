package com.example.demo.controller;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    //获取购物车列表
    @PostMapping("/getShoppingCart")
    public Result getShoppingCart(@RequestParam("user_id") int user_id){
        List<ShoppingCart> list = new ArrayList<>();
        list.addAll(shoppingCartService.getShoppingCart(user_id));
        Result res = new Result();
        if(list.size()>0){
            res.setCode(20000);
            res.setMessage("成功");
            res.setData(list);
        } else {
            res.setCode(STATUS_FAIL);
            res.setMessage("获取失败");
        }
        return res;
    }
    //添加购物车
    @PostMapping("/addShoppingCart")
    public Result addShoppingCart(@RequestParam("user_id") int user_id,
                                  @RequestParam("productID") int product_id){
        Result res = new Result();
        if(shoppingCartService.addShoppingCart(user_id, product_id)>0) {
            res.setCode(20000);
            res.setMessage("添加成功");
        } else  {
            res.setCode(STATUS_FAIL);
            res.setMessage("添加失败");
        }
        return res;
    }
    //更新购物车
    @PostMapping("/updateShoppingCart")
    public Result updateShoppingCart(@RequestParam("user_id") int user_id,
                                     @RequestParam("productID") int productID,
                                     @RequestParam("currentValue") int cart_num){
        Result res = new Result();
        if(shoppingCartService.updateShoppingCart(user_id,productID,cart_num)>0) {
            res.setCode(20000);
            res.setMessage("修改数量成功");
        } else {
            res.setCode(STATUS_FAIL);
            res.setMessage("添加失败");
        }
        return res;
    }
    //删除购物车
    @PostMapping("/deleteShoppingCart")
    public Result deleteShoppingCart(@RequestParam("user_id") int user_id,
                                     @RequestParam("product_id") int product_id){
        Result res = new Result();
        System.out.println(user_id);
        System.out.println(product_id);
        if(shoppingCartService.deleteShoppingCart(user_id,product_id)>0) {
            res.setMessage("删除成功");
            res.setCode(20000);
        };
        return res;
    }
    //上传图片
    @RequestMapping("/getImg2")
    public void getImg2(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream("C:/Users/haoyun.dai/Desktop/img/Capture.PNG");
            os = response.getOutputStream();
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
