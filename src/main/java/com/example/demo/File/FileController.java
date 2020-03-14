package com.example.demo.File;

import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import com.example.demo.Util.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
public class FileController {
    //前端上传文件的接口
    @RequestMapping(value = "/uploadfile")
    public Result getFile(@RequestParam("file") MultipartFile[] file, HttpServletResponse response, @RequestParam("pid")int pid) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        int length = file.length;
        System.out.println("拿到的产品的pid:" + pid);
        System.out.println(length);
        //创建图片对应的目录
        File destFile1 = new File("/home/ybx/Documents/image/" + pid);
        if(!destFile1.exists()){
            destFile1.mkdirs();
        }
        for (int i = 0; i < length; i++) {
            // 获取文件名，带后缀
            String originalFilename = file[i].getOriginalFilename();
            System.out.println(originalFilename);
            // 获取文件的后缀格式
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
            System.out.println(fileSuffix);
            //得到文件的真实路径
            File destFile = new File(destFile1,UUIDUtil.getUUID() + "." + fileSuffix);
            file[i].transferTo(destFile);
            //对文件的人物进行情绪识别

        }
        if(file.length != 0) {
            return new Result(Msg.LoadFileSuccess);
        }else
        {
            return new Result(Msg.LoadFileFaild);
        }
    }
}
