package com.example.bhonesh.hack36;

/**
 * Created by bhonesh on 26/1/19.
 */

public class DataSaveClass {

    public static String address, date, time, subject, standard;
    public static String name;
    public static boolean validTaken = false;

    public static void printClass()
    {
        System.out.printf("%s %s %s %s %s %s\n",address, date, time, subject, standard, name);
    }
}
