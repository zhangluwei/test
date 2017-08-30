
package com.luwei.http;

import java.util.Map;

import com.google.common.collect.Maps;

 
public class HttpMain {

    public static void main(String[] args) {

        System.out.println("this is start");

         post();
//        postQuery();

        System.out.println("this is end");
    }

    public static void post() {

        try {
            Map params = Maps.newHashMap();

            params.put("data", "is as test");

//             String responseStr = HttpInvoker.post("http://172.20.17.189:8081/page/data", params);
            
//            String responseStr = HttpInvoker.post("http://10.17.5.31:4444", "{a:123}");
            
            Map<String, String> headers = Maps.newHashMap();
            headers.put("Content-Type", "application/json; charset=UTF-8");
            
//            String responseStr = HttpInvoker.post("http://127.0.0.1:4444", "{a:12日阿斯顿高安师范3}",headers);
//            HttpInvoker.post("http://172.20.17.189:8081/page/data", "{a:12日阿斯顿高安师范3}",headers);
            
            
            
            
            
            
            
// 
            
//            System.out.println(responseStr);

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void postQuery() {

        try {
            Map params = Maps.newHashMap();

            params.put("userid", "505");
            params.put("sign", "6d72deff74106bc95b69d74b3725207e");
            params.put("pageno", "1");
            params.put("pagesize", "10");
            
            //http://127.0.0.1:8080/xnol-partner-web/tongzhoudianzi/orderlist.json?userid=888000&sign=6d72deff74106bc95b69d74b3725207e

//            curl -d "userid=888000&sign=6d72deff74106bc95b69d74b3725207e" "http://127.0.0.1:8080/xnol-partner-web/tongzhoudianzi/orderlist.json"
            
//            String responseStr = HttpInvoker.post("http://172.20.20.86:9018/xnol-partner-web/tongzhoudianzi/orderlist.json", params);

//            System.out.println(responseStr);

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}