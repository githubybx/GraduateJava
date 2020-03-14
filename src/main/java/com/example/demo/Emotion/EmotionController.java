package com.example.demo.Emotion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmotionController {
    @Autowired
    EmotionService emotionService;
    //更新商品的数据信息
    @RequestMapping("/post/update/goodsEmotionMsg")
    public void updateGoodsMsg(@RequestBody Map<String, String> map){
        //得到商品的pid
        int pid = Integer.parseInt(map.get("pid"));
        //根据pid得到eid
        Emotion byPid = emotionService.findByPid(pid);
        //得到eid
        int eid = byPid.getEid();
        //更新商品的数据信息
        Emotion emotion = new Emotion();
        emotion.setEid(eid);
    }
}
