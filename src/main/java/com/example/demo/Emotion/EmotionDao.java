package com.example.demo.Emotion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionDao extends JpaRepository<Emotion,Integer> {
    public Emotion findByPid(int pid);
}
