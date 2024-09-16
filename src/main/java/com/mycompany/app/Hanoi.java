package com.mycompany.app;

public class Hanoi {
    public static String play(int n, char from_pole, char to_pole, char aux_pole){
        String text = "";
        if(n != 0){
            text = text + play(n - 1, from_pole, aux_pole, to_pole);
            // System.out.println("Move disk " + n + " from " + from_pole + " to " + to_pole);
            text = text + "Move disk " + n + " from " + from_pole + " to " + to_pole + "<br>";
            text = text + play(n - 1, aux_pole, to_pole, from_pole);
        }
        return text;
    }    
}