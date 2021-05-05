package com.example.demo.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117624941";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQClkiaPxiyw/EqQ5RrWx3ZLG50cNIJUg17CtNKD0zeQl3r4z489lp2muvp2cg0NGI5qEqoGqo1WMJ5tCS3Do0FWzTBmljtwIdUCjPZs965PM1wOXaSkW7kdgr1TyRbV5DIMsGUIef3Xavwwk+6QvIid3Xc4wWjBrn9eMBjRxXNe7l9dPA4VZuUHs2XJzIEGe8XPtNKa6G2yCVaHcm7Chftn5/lRJD189eu1GItiH5PAsCuL70Q1R4ecyz+CqyNruiSC/lmM7OJ7PdUXVYthYJ5NlSIWHrwFUNpBDk7oSvSh1YiJjuLzabc3snSoJ3hg8ynzq8F0gVhs+AIPEGY/t171AgMBAAECggEBAIiONce2xv1h144Rp0UlVWc06ytsE2Hox6sGv+mBtv5GMWIsrhM5ueTdqd0uy5zVd//8TMcau18u0jtTqq8EYstYiGbT2UnuXWSxJj1ROi6QSYh/q17zV4YDYmtMGs1mW/EjOvD2zGlzD3RxTf2JwZOSKNZijifP57SjLpU0qKbN1f07zeG9C4nvW/uCXj6VZvsgMty6z7UbGXq/lA7W16im2NZ5zuJmN7a9yofshEp8TZFFLCusFkE6REsVLLOxcOnOpNov9mjZgCXNwaB2FMSgJ/uYEcBU7CflzU0xCA3NX+UMiZWbP6lCtVK+3Yed2auztK/QtGxC3dJGQe061QECgYEA47IPr6Vu8wapLZ6jIRYVzG6b54sOvAK+LsxsNzwx6HYHQRiW+G3frp1D0cSLYGSOTC1gZeWcukzHVCecWImXefN9n+Q8Pvl6c/HR0bqMdLgMZObSJRQ7dGO1/NDKA8qpCMqfC58PTx5KvyU7ezpT3hxE2hcWM9C73n3/APDsm1ECgYEAuicZ5uhnu2kDhdjpVVNUT2x30mQ446Rxo3zXu3G9n0VRQ10Va0T6uI0hKTX0r2By6vTB/k4JZx5W/Biv/oDrfxEpn66KQP2RPz0hLW5pqxiqRK23kGdmTvm73pcy8IFKZ5lKqyjB5UiVzujOPo4jnniO5OxeaTk21+8XGN5GmGUCgYEAyvq2PxfUQ3PhpxhvRhSBFEBaXVw6o2IylleH9OmFeDyXlPFNzGNubyQlDEARG7oonEIrWEsLn4zIeP3iw47M6Vsl1z7Icj9GaUvehv+tLHPSILUgCwvxQH2PA7RBEoY8j+jJRbvjEt3nNmUDlIPXtf4vZtgD4+clQ1/Azt73njECgYAmBCY+CehlVaTqiMneKw5kyfoOdXlIxCSRBsXn+eqHxFg8MZ5WMdgiKHBFQkeeKUxOv31+ueEhtgh9o20NxLZTVOXzPmntq9sl1w4XgR0DXB4puHBshTFXn5jGdIpqo3zWe2/MVJ6EfLZbcx/rloufqW9FQSBmzNBueN12rq4sIQKBgQDRP3AkQzEUAj3Js9y5LDjHsodN8vDyJcbx3gjcZOWZXyZ12ac0Td9e2j4UykH1yoIAo1SpDoGrG9hmey0KmaXOza7dWc9bxfYuejEOqYS7m7HrPk0bl4KGB3NnTBeervikb7VGjvrJxfP6G8PtS4aDgmQIfZI7gsMIA2GKdbdSEg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvjpP8KsEcNa99uT34efu0zu+FGJqJORgFPvMZFQgTiywKCbtcXxzrLsR7LMVu3QkIbQyZeGg//edIyYH/Wv/DcOXOTQa75CdXrWc1n1wG2cgHM4EMNsm+H6j8EkisHEtPsKQ3tQct45ZnphySufb3T08MwC+jaZOM4jNxOPNyIg1TQh3ynD2bSJL7GOo+13GwmbRKZwnl1oSjla3ceazdvcNeAREDM70cywarYLRKOBNHD8yzaOlP02XjbB1TTjp/cxSpck11v+uVeQWuFGNGKEo/IfRjuTVvCXIb2URHQ+/BlEe8p46KKpmIxSyMvMQpiCYXb4uA5yfjurZRDgFAwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://cloudink.free.idcfengye.com/return.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://cloudink.free.idcfengye.com/";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

