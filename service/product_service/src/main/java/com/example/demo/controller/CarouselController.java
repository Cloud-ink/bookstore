package com.example.demo.controller;

import com.example.demo.pojo.Carousel;
import com.example.demo.result.Result;
import com.example.demo.service.CarouselService;
import com.example.demo.service.ProductService;
import io.swagger.annotations.Api;
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

import static com.example.demo.result.Constants.*;

@Api(description = "轮播图操作")
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    CarouselService carouselService;

    @PostMapping("/listCarousels")
    public Result listCarousels(){
        Result res = new Result();
        List<Carousel> carouselList = carouselService.listCarousels();
        res.setCode(STATUS_OK);
        res.setData(carouselList);
        res.setMessage(MESSAGE_OK);
        System.out.println(res);
        return res;
    }

//    //文件流形式
//    @RequestMapping("/getCoroulsel")
//    public void getImg2(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        FileInputStream fis = null;
//        OutputStream os = null;
//        try {
//            fis = new FileInputStream("d:/log.png");
//            os = response.getOutputStream();
//            int count = 0;
//            byte[] buffer = new byte[1024 * 8];
//            while ((count = fis.read(buffer)) != -1) {
//                os.write(buffer, 0, count);
//                os.flush();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
