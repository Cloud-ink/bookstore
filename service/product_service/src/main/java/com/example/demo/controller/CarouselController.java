package com.example.demo.controller;

import com.example.demo.pojo.Carousel;
import com.example.demo.result.Result;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarouselController {
    @Autowired
    ProductService productService;

    @PostMapping("/carousel")
    public Result getCarousel(){
        Result res = new Result();
        List<Carousel> list = new ArrayList<>();
        list.addAll(productService.getCarouselList());
        res.setCode(20000);
        res.setMessage("获取成功");
        res.setData(list);
        return res;
    }

    @RequestMapping("/getCoroulsel")
    public void getImg2(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream("d:/log.png");
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
