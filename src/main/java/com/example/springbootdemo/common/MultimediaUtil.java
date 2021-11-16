package com.example.springbootdemo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/4/19 10:02</br>
 * @since JDK 1.8
 */
@Slf4j
public class MultimediaUtil {

    /**
     * 发送语音
     * @param toUsers
     */
    public static void sendVoice(List<String> toUsers){
        //todo
    }

    /**
     * 发送语音(单个)
     * @param toUser
     */
    public static void sendVoice(String toUser){
        HashMap<String, Object> params = new HashMap<>(32);
//        int tenantId = 2374;
        int tenantId = 2182;
        String token = getVoiceToken();
        String taskName = "矛调测试任务";
        params.put("token", token);
        params.put("taskType", "ROBOT_CALL");
        params.put("taskName", taskName);
        params.put("projectName", "绍兴市新昌县东茗乡人民政府");
        params.put("agentGroupId", "129");
        params.put("agentGroupName", "绍兴市新昌县东茗乡人民政府");
        params.put("robotSwitch", "ON");
        params.put("blacklistFilterSwitch", "ON");
        params.put("description", "自定义话术配置（任务描述）");
        params.put("getNumbers", null);
        params.put("concurrentCount", 1);
        params.put("bombScreenCount", 1);
        params.put("queueWay", "ROUND_ROBIN");
        params.put("taskFrequencyType", "SINGLE");
        params.put("executionType", null);
        params.put("taskSpecificStartTime", getNowDate());
        params.put("taskSpecificEndTime", getTomorrow());
        params.put("taskStartDate", null);
        params.put("taskEndDate", null);
        params.put("callTime", null);
        params.put("executionDay", null);
        params.put("abnormalNumberRecall", "OFF");
        params.put("recallType", null);
        params.put("recallCount", null);
        params.put("recallIntervalTime", null);
        params.put("tenantId", tenantId);
        params.put("sceneName", "绍兴市新昌县东茗乡人民政府");
        params.put("speakType", "TTS");
        params.put("tone", "Xiaoyun");
        params.put("volume", "50");
//        String addTaskUrl = "http://123.103.15.158:9904/api/task/addTask";
//        String uploadPhoneUrl = "http://123.103.15.158:9904/api/task/number/upload";
        String addTaskUrl = "http://36.134.50.5:9904/api/task/addTask";
        String uploadPhoneUrl = "http://36.134.50.5:9904/api/task/number/upload";
        //新建任务
        JSONObject taskResult = HttpUtil.doPostStr(addTaskUrl, JSON.toJSONString(params));
        log.info("新建任务返回------" +taskResult.toJSONString());
        HashMap<String, Object> params2 = new HashMap<>(8);
        params2.put("tenantId",tenantId);
        params2.put("token",getVoiceToken());
        params2.put("taskName",taskName);
        List<HashMap<String, Object>> data = new ArrayList<>();
        HashMap<String, Object> phones = new HashMap<>(8);
        phones.put("requestId","1234567890");
        phones.put("phone",toUser);
        phones.put("name","ceshi");
        data.add(phones);
        params2.put("data",data);
        //上传手机号
        JSONObject uploadResult = HttpUtil.doPostStr(uploadPhoneUrl, JSON.toJSONString(params2));
        log.info("上传手机号返回------" + uploadResult.toJSONString());
        boolean containsKey1 = taskResult.containsKey("code");
        boolean containsKey2 = uploadResult.containsKey("code");
        int code1 = (int) taskResult.get("code");
        int code2 = (int) uploadResult.get("code");
        if (!containsKey1 || 200 != code1 || !containsKey2 || 200 != code2){
            throw new RuntimeException("发送语音失败");
        }
    }

    /**
     * 获取明天时间
     * @return
     */
    private static Object getTomorrow() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return simpleDateFormat.format(instance.getTime());
    }

    /**
     * 获取当前时间
     * @return
     */
    private static Object getNowDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        sendVoice("15357223344");
    }

    /**
     * 获取token
     * 鉴权信息（accountNo+当前时间的时间戳（yyyyMMddHHmmss）,使用base64编码）
     * 例：accountNo=abc123; 时间戳=20200501000000
     * @return
     */
    private static String getVoiceToken() {
        String accountNo = "unioncastdmx0709";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(date);
        final BASE64Encoder encoder = new BASE64Encoder();
        final String text = accountNo + format;
        byte[] textByte = null;
        try {
            textByte = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final String encodedText = encoder.encode(textByte);
        log.info("token------"+encodedText);
        return encodedText;
    }

    /**
     * 发送短信
     * @param toUsers
     */
    public static void sendMsg(List<String> toUsers, String content){
        //todo
    }

    /**
     * 发送短信(单个)
     * @param toUser
     */
    public static void sendMsg(String toUser){
        //todo
    }

}
