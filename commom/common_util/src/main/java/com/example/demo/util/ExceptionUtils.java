package com.example.demo.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {
    public static String getMessage(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;

        //出错误跟踪站中取出字符串，放到字符流中
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            //将异常信息输出在控制台
            e.printStackTrace(pw);
            //将异常信息返回
            pw.flush();
            sw.flush();
        } finally {
            if(sw!=null) {
                try {
                    sw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (pw!=null) {
                pw.close();
            }
            return sw.toString();
        }
    }
}
