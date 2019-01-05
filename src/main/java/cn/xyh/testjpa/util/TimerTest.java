package cn.xyh.testjpa.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by xyh on 2018/12/17
 */
public class TimerTest {

    public static void main(String[] args) {
        new Reminder(1);
    }

    static class Reminder{
        Timer timer;
        public Reminder(int sec){
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask(){
                public void run(){

                    System.out.println("haha");
                }
            }, 0, sec * 1000);
        }
    }
}
