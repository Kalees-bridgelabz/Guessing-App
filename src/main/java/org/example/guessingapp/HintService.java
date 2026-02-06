package org.example.guessingapp;

public class HintService {


    public static String getHintCount(int target,int hintCount){
        if(hintCount ==1){
                return (target%2 == 0) ? "the target number is Even" : "the target number is odd";
        } else if (hintCount == 2 || hintCount == 3) {
                if(target<=10)
                    return "the target is less than or equal to 10";
            if(target<=20)
                return "the target is less than or equal to 20";
            if(target<=30)
                return "the target is less than or equal to 30";
            if(target<=40)
                return "the target is less than or equal to 40";
            if(target<=50)
                return "the target is less than or equal to 50";
            if(target<=60)
                return "the target is less than or equal to 60";
            if(target<=70)
                return "the target is less than or equal to 70";
            if(target<=80)
                return "the target is less than or equal to 80";
            if(target<=90)
                return "the target is less than or equal to 90";
            if(target<=100)
                return "the target is less than or equal to 100";
        }
        return "NO MORE HINTS AVILLABLE";
    }
}
