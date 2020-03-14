package com.example.demo.BaiDuAPI;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import com.example.demo.Util.FaceResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AIcontroller {
  @RequestMapping("/get/dector")
    public Result getDectreor(@RequestParam("path")String path) throws IOException {
      try {
          String result = FaceDetect.faceDetect(path);
          if (result == "") {
              return new Result(Msg.EmotionDetectFailed);
          }
          FaceResult faceRsult = FaceResultUtil.getFaceRsult(result);
          if (faceRsult != null) {
              return new Result(Msg.EmotionDetectSuccess, faceRsult);
          } else {
              return new Result(Msg.EmotionDetectFailed);
          }
      }catch (Exception exception){
          return new Result(Msg.EmotionDetectFailed);
      }
  }
}
