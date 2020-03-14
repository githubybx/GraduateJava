package com.example.demo.BaiDuAPI;

import com.example.demo.BaiDuAPI.*;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.*;

/**
 * 人脸检测与属性分析
 */
public class FaceDetect {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String faceDetect(String path) throws IOException {
        //读取文件字节流
        byte[] str = FileUtil.readFileByBytes(path);
        //将文件的字节流进行编码
        String encode = Base64Util.encode(str);
        //System.out.println(encode);
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", encode);
            map.put("face_field", "faceshape,facetype,expression,emotion");
            map.put("image_type", "BASE64");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.17223a987f61c7286f69f64d17e7fd9e.2592000.1586743270.282335-18824985";

            String result1 = HttpUtil.post(url, accessToken, "application/json", param);
//            //System.out.println(result);
//            String[] split = result1.split("\"expression\":");
//            String result = split[1].split(",")[0].split(":")[1];
//            System.out.println(result);
            System.out.println(result1);
            return result1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

 public static void main(String[] args) throws IOException {
        FaceDetect.faceDetect("/home/ybx/Pictures/sss.png");
    }
}