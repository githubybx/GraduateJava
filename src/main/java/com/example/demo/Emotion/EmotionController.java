package com.example.demo.Emotion;


import com.example.demo.Product.Product;
import com.example.demo.Product.ProductService;
import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import org.dom4j.io.ElementModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class EmotionController {
    @Autowired
    EmotionService emotionService;
    @Autowired
    ProductService productService;
    //更新商品的数据信息
    @RequestMapping("/post/update/goodsEmotionMsg")
    public void updateGoodsMsg() throws IOException {
        String path = "";
        int pid = 0;
      emotionService.faceDetectResult(path, pid);
    }
    //查出所有商品评分信息
    @RequestMapping(value = "/get/emotion/all",method = RequestMethod.GET)
    public Result findAll(){
        List<Emotion> allEmotion = emotionService.findAllEmotion();
        List<Emotion2> allEmotion2 = new ArrayList<>();
        System.out.println(allEmotion.size());
        if(allEmotion != null){
            for(Emotion emotion : allEmotion){
                Emotion2 emotion2 = new Emotion2();
                int pid = emotion.getPid();
                Optional<Product> product = productService.selectProductById(pid);
                emotion2.setPname(product.get().getPname());
                emotion2.setAngry(emotion.getAngry());
                emotion2.setDisgust(emotion.getDisgust());
                emotion2.setFear(emotion.getFear());
                emotion2.setGrade(emotion.getGrade());
                emotion2.setGrimace(emotion.getGrimace());
                emotion2.setNeutral(emotion.getNeutral());
                emotion2.setHappy(emotion.getHappy());
                emotion2.setPouty(emotion.getPouty());
                emotion2.setSad(emotion.getSad());
                allEmotion2.add(emotion2);
            }
            return new Result(Msg.GetAllEmotionMsgSuccess,allEmotion2);
        }else {
            return new Result(Msg.GetAllEmotionMsgFailed,"人脸分析信息为空");
        }
    }
}
