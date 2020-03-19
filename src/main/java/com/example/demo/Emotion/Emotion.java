package com.example.demo.Emotion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Emotion")
public class Emotion {
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
    //自身的id,作为主键
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int eid;
    //hayyp的值的1/9
    double grade;

    public Emotion(int angry, int disgust, int fear, int happy, int sad, int surprise, int neutral, int pouty, int grimace, int pid, double grade) {
        this.angry = angry;
        this.disgust = disgust;
        this.fear = fear;
        this.happy = happy;
        this.sad = sad;
        this.surprise = surprise;
        this.neutral = neutral;
        this.pouty = pouty;
        this.grimace = grimace;
        this.pid = pid;
        this.grade = grade;
    }
}
