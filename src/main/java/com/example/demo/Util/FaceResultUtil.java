package com.example.demo.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.BaiDuAPI.FaceResult;

//对人脸分析的结果进行解析
public class FaceResultUtil {
    public static FaceResult getFaceRsult(String result){
            if (result == null) {
                System.out.println("result null");
                return null;
            }
            JSONObject jsonObject = JSON.parseObject(result);
            String error_code = jsonObject.get("error_code").toString();
            String error_msg = jsonObject.get("error_msg").toString();
            //得到了result:{"face_num":1,"face_list":[{"face_shape":{"probability":0.6,"type":"oval"},"expression":{"probability":1,"type":"smile"},"face_type":{"probability":0.99,"type":"human"},"angle":{"roll":9.96,"pitch":3.87,"yaw":-4.25},"face_token":"d888253e91ad87405bde4491bdda7154","location":{"top":177.81,"left":818.19,"rotation":13,"width":156,"height":162},"face_probability":1}]}
            String result1 = NUllTestUtil.testNUll(jsonObject.get("result"));
            if(result1 == null){
                    return null;
            }
            System.out.println(result1);
            JSONObject jsonObject1 = JSON.parseObject(result1);
            String face_list = NUllTestUtil.testNUll(jsonObject1.get("face_list"));
            if (face_list == null) {
                return null;
            }
            JSONArray objects = JSON.parseArray(face_list);
            //得到JSONArray中的数据
            //{"face_shape":{"probability":0.6,"type":"oval"},"expression":{"probability":1,"type":"smile"},"face_type":{"probability":0.99,"type":"human"},"angle":{"roll":9.96,"pitch":3.87,"yaw":-4.25},"face_token":"d888253e91ad87405bde4491bdda7154","location":{"top":177.81,"left":818.19,"rotation":13,"width":156,"height":162},"face_probability":1}
            String array = NUllTestUtil.testNUll(objects.get(0).toString());
            if (array == null) {
                return null;
            }
            JSONObject jsonObject2 = JSON.parseObject(array);
            //得到了smile: {"probability":1,"type":"smile"}
            String emotion = NUllTestUtil.testNUll(jsonObject2.get("emotion"));
            if (emotion == null) {
                return null;
            }
            JSONObject emotion1 = JSON.parseObject(emotion);
            //得到了　"type":"smile"
            String emotion_type = NUllTestUtil.testNUll(emotion1.get("type"));
            if (emotion_type == null) {
                return null;
            }
            String emotion_probability = NUllTestUtil.testNUll(emotion1.get("probability"));
            System.out.println(emotion_type);
            System.out.println(emotion);
            //得到了token
            String face_token = NUllTestUtil.testNUll(jsonObject2.get("face_token"));
            System.out.println(face_token);
            //得到了face_type: {"probability":0.99,"type":"human"}
            String string1 = NUllTestUtil.testNUll(jsonObject2.get("face_type"));
            JSONObject jsonObject3 = JSON.parseObject(string1);
            String face_probability = NUllTestUtil.testNUll(jsonObject3.get("probability"));
            String face_type = NUllTestUtil.testNUll(jsonObject3.get("type"));
            FaceResult faceResult = new FaceResult();
            faceResult.setError_code(error_code);
            faceResult.setError_msg(error_msg);
            faceResult.setEmotion_type(emotion_type);
            faceResult.setEmotion_probability(emotion_probability);
            faceResult.setFace_probability(face_probability);
            faceResult.setFace_type(face_type);
            faceResult.setFace_token(face_token);
            return faceResult;
        }
}
