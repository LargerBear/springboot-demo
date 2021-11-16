package com.example.springbootdemo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/4/27 10:16</br>
 * @since JDK 1.8
 */
@Slf4j
public class YZDService {

    private static String HOST = "http://ls-shzl-api.jx-ding.com.cn/v1";

    private static String TOKEN_URL = HOST + "/yzd/get_token";

    private static String CREATE_URL = HOST + "/yzd/create?token=" + getToken();

    private static String INVITE_URL = HOST + "/yzd/invite?token=" + getToken();

    private static String HISTORY_URL = HOST + "/yzd/incident/his?token=" + getToken() + "&code=CODE";

    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        JSONObject user = new JSONObject();
        user.put("uid","77664570");
        user.put("uname","王坚平");
        array.add(user);
        JSONObject user2 = new JSONObject();
        user2.put("uid","24003640");
        user2.put("uname","尹巧萍");
        array.add(user2);
        invite("202104280065", array);
//        getHistory("202104270009");


    }

    /**
     * 获取token
     * @return
     */
    private static String getToken() {
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("name","lssc"));
        formParams.add(new BasicNameValuePair("pwd","lssc0427"));
        JSONObject jsonObject = HttpUtil.doPostStr(TOKEN_URL, formParams);
        if (null != jsonObject && jsonObject.containsKey("status") && 200 == (int)jsonObject.get("status")){
            Map data = (Map) jsonObject.get("data");
            if (null != data && data.containsKey("token")){
                String token = (String) data.get("token");
                return token;
            }
        }
        log.info("获取token出错");
        return null;

    }


    /**
     * 创建
     * @return
     */
    private static Operations create(){
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("type","固废处理"));
        formParams.add(new BasicNameValuePair("desc","测试"));
        formParams.add(new BasicNameValuePair("area","遂昌县"));
        formParams.add(new BasicNameValuePair("create_uid","928171"));
        formParams.add(new BasicNameValuePair("create_uname","程醒强"));
        formParams.add(new BasicNameValuePair("fromwhere","丽水遂昌"));
        JSONObject jsonObject = HttpUtil.doPostStr(CREATE_URL, formParams);
        Operations operations = JSON.toJavaObject(jsonObject, Operations.class);
        return operations;
    }


    /**
     * 拉人
     * @param code
     * @return
     */
    private static JSONObject invite(String code, JSONArray users){
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("code",code));
        formParams.add(new BasicNameValuePair("user_list", users.toJSONString()));
        formParams.add(new BasicNameValuePair("remark","遂昌县"));
        formParams.add(new BasicNameValuePair("is_broadcast","true"));
        JSONObject jsonObject = HttpUtil.doPostStr(INVITE_URL, formParams);
        return jsonObject;
    }

    /**
     * 获取聊天记录
     * @param code
     * @return
     */
    private static JSONArray getHistory(String code){
        JSONObject jsonObject = HttpUtil.doPostStr(HISTORY_URL.replace("CODE", code), "");
        JSONArray array = (JSONArray) jsonObject.get("data");
        return array;
    }
}
