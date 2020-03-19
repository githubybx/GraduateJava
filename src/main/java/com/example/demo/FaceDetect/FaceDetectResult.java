package com.example.demo.FaceDetect;


import com.example.demo.BaiDuAPI.FaceDetect;
import com.example.demo.BaiDuAPI.FaceResult;
import com.example.demo.Emotion.Emotion;
import com.example.demo.Emotion.EmotionDao;
import com.example.demo.Emotion.EmotionService;
import com.example.demo.Util.FaceResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

//将人脸分析出的数据添加到数据库中
public class FaceDetectResult {
//    @Autowired
//    static EmotionDao emotionDao;
//    public static void faceDetectResult(FaceResult faceResult, String path,int pid) throws IOException {
//        String result = FaceDetect.faceDetect(path);
//        if (result == "") {
//            //return new Result(Msg.EmotionDetectFailed);
//            System.out.println("人脸数据解析失败");
//        }
//        FaceResult faceRsult = FaceResultUtil.getFaceRsult(result);
//        if (faceRsult != null) {
//            System.out.println("解析失败");
//        } else {
//            String emotion_type = faceResult.getEmotion_type();
//            Emotion byPid = emotionDao.findByPid(pid);
//            Emotion aSwitch = getSwitch(emotion_type, byPid);
//            //将数据存入到数据库中
//            emotionDao.save(aSwitch);
//        }
//    }
//    //根据人脸解析出的结果,去更改数据库
//    //angry:愤怒 disgust:厌恶 fear:恐惧 happy:高兴 sad:伤心 surprise:惊讶 neutral:无表情 pouty: 撅嘴 grimace:鬼脸
//    public static Emotion getSwitch(String str, Emotion emotion){
//        switch (str){
//            case "angry":{
//                emotion.setAngry(emotion.getAngry() + 1);
//                break;
//            }
//            case "disgust":{
//                emotion.setDisgust(emotion.getDisgust() + 1);
//                break;
//            }
//            case "fear":{
//                emotion.setFear(emotion.getFear() + 1);
//                break;
//            }
//            case "happy":{
//                emotion.setHappy(emotion.getHappy() + 1);
//                break;
//            }
//            case "sad":{
//                emotion.setSad(emotion.getSad() + 1);
//                break;
//            }
//            case "surprise":{
//                emotion.setSurprise(emotion.getSurprise() + 1);
//                break;
//            }
//            case "neutral":{
//                emotion.setNeutral(emotion.getNeutral() + 1);
//                break;
//            }
//            case "pouty":{
//                emotion.setPouty(emotion.getPouty() + 1);
//                break;
//            }
//            case "grimace":{
//                emotion.setGrimace(emotion.getGrimace() + 1);
//                break;
//            }
//            default:{
//                break;
//            }
//        }
//        return emotion;
//    }

}
