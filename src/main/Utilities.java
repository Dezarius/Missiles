/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author janabelmann
 */
public class Utilities {
    
    private static long timeInMilis = 0;
    
    public static void addTime(long deltaTime) {
        timeInMilis += deltaTime;
    }
    
    public static void resetTimer() {
        timeInMilis = 0;
    }
    
    public static long getTime() {
        return timeInMilis;
    }
    
    public static String getTimer() {
        String result = "";
        int minutes = (int) ((timeInMilis / 1000) / 60);
        int seconds = (int) ((timeInMilis / 1000) % 60);
        if(minutes < 10) {
            result += "0";
        }
        result += minutes + ":";
        if(seconds < 10) {
            result += "0";
        }
        result += seconds;
        return result;
    }
    
}
