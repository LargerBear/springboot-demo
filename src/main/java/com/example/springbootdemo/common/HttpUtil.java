package com.example.springbootdemo.common;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.model.DemoUser;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.*;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/4/16 16:54</br>
 * @since JDK 1.8
 */
public class HttpUtil {
    /**
     * 处理doget请求
     *
     * @param url
     * @return
     */
    public static JSONObject doGetStr(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "utf-8");
                jsonObject = JSONObject.parseObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;

    }

    /**
     * 处理post请求
     *
     * @param url
     * @return
     */
    public static JSONObject doPostStr(String url, String outStr) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        Map<String,String> map = new HashMap<>(8);
        map.put("Accept","application/json, text/plain, */*");
        map.put("Accept-Encoding","gzip, deflate");
        map.put("Accept-Language","zh-CN,zh;q=0.9");
        map.put("Content-Type","application/json;charset=UTF-8");
        JSONObject jsonObject = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
            httpPost.setEntity(new StringEntity(outStr, "utf-8"));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            jsonObject = JSONObject.parseObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 表单提交
     * @param url
     * @param outStr
     * @return
     */
    public static JSONObject doPostStr(String url, List<NameValuePair> outStr) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        JSONObject jsonObject = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("content-Type", "application/x-www-form-urlencoded");
        try {
            UrlEncodedFormEntity he=new UrlEncodedFormEntity(outStr,"UTF-8");
            httpPost.setEntity(he);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            jsonObject = JSONObject.parseObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void main(String[] args) {
        DemoUser u1 = new DemoUser();
        u1.setId("1");
        u1.setUserName("zhangsan");
        u1.setSex("1");
        DemoUser u2 = new DemoUser();
        u2.setId("1");
        u2.setUserName("lisi");
        BeanUtils.copyProperties(u2, u1);
        System.out.println(u1.toString() + u2.toString());

    }

}
