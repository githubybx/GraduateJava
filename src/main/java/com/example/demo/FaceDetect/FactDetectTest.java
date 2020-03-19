package com.example.demo.FaceDetect;

public class FactDetectTest {
    public static void main(String[] args) {
        getSwitch("happy");
        getSwitch("sad");
        getSwitch("hha");
    }
    public static void getSwitch(String str){
        switch (str){
            case "happy":
            {
                System.out.println("happy");
                break;
            }
            case "sad":
            {
                System.out.println("sad");
                break;
            }
            default:
                System.out.println("default");
                break;

        }
    }
}
