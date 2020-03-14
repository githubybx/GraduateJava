package com.example.demo.Emotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
