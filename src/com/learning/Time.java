package com.learning;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;


public class Time {
    private  final Scanner sc = new Scanner(System.in);

    public LocalTime takeTime (){
       return  LocalTime.parse(sc.next());
    }

}
