package com.example.demo.Emotion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emotion2 {
    int angry = 0;
    int disgust = 0;
    int fear = 0;
    int happy = 0;
    int sad = 0;
    int surprise = 0;
    int neutral = 0;
    int pouty = 0;
    int grimace = 0;
    //pid,物品的id,作为外键存在
    int pid;
    double grade;
    String pname;
}
