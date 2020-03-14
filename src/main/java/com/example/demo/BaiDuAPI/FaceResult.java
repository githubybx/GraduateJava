package com.example.demo.BaiDuAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaceResult {
    String error_code;
    String error_msg;
    String face_token;
    String emotion_probability;
    String emotion_type;
    String face_probability;
    String face_type;
}
