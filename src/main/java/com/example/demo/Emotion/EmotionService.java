package com.example.demo.Emotion;

import com.example.demo.BaiDuAPI.FaceDetect;
import com.example.demo.BaiDuAPI.FaceResult;
import com.example.demo.Util.FaceResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmotionService {
    @Autowired
    EmotionDao emotionDao;
    //查看对应商品的数据信息,根据商品的pid查
    public Emotion findByPid(int pid){
       return emotionDao.findByPid(pid);
    }
    //更新商品的信息
    public Emotion save(Emotion emotion){
        return emotionDao.save(emotion);
    }
    ////将人脸分析出的数据添加到数据库中
    public Emotion faceDetectResult(String path, int pid) throws IOException {
        String result = FaceDetect.faceDetect(path);
        if (result == "") {
            //return new Result(Msg.EmotionDetectFailed);
            System.out.println("人脸数据解析失败");
            return null;
        }
        FaceResult faceRsult = FaceResultUtil.getFaceRsult(result);
        if (faceRsult == null) {
            System.out.println("人脸数据解析失败");
            return null;
        } else {
            String emotion_type = faceRsult.getEmotion_type();
            //这里可能会产生空指针异常
            Emotion byPid = emotionDao.findByPid(pid);
            Emotion save = null;
            if(byPid == null){
                save =  emotionDao.save(new Emotion(0, 0, 0, 0, 0, 0, 0, 0, 0, pid, 0.0));
            }else {save = byPid;}
            Emotion aSwitch = getSwitch(emotion_type, save);
            //将数据存入到数据库中
            return emotionDao.save(aSwitch);
        }
    }
    //根据人脸解析出的结果,去更改数据库
    //angry:愤怒 disgust:厌恶 fear:恐惧 happy:高兴 sad:伤心 surprise:惊讶 neutral:无表情 pouty: 撅嘴 grimace:鬼脸
    public  Emotion getSwitch(String str, Emotion emotion){
        switch (str){
            case "angry":{
                emotion.setAngry( emotion.getAngry() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "disgust":{
                emotion.setDisgust(emotion.getDisgust() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "fear":{
                emotion.setFear( emotion.getFear() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "happy":{
                emotion.setHappy(emotion.getHappy() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "sad":{
                emotion.setSad( emotion.getSad() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "surprise":{
                emotion.setSurprise( emotion.getSurprise() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "neutral":{
                emotion.setNeutral(emotion.getNeutral() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "pouty":{
                emotion.setPouty(emotion.getPouty() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            case "grimace":{
                emotion.setGrimace(emotion.getGrimace() + 1);
                emotion.setGrade((double)emotion.getHappy() / (calcGrade(emotion)));
                break;
            }
            default:{
                break;
            }
        }
        return emotion;
    }
    public int  calcGrade(Emotion emotion){
        int all = emotion.getHappy() + emotion.getAngry() + emotion.getDisgust() + emotion.getFear()
                + emotion.getGrimace() + emotion.getNeutral() + emotion.getPouty() + emotion.getSad()
                + emotion.getSurprise();
        return all;
    }
    public List<Emotion> findAllEmotion(){
        return emotionDao.findAll();
    }
}
