package com.mission.mars.mars;

import org.springframework.stereotype.Service;

public class Utilities {

    public static Boolean isPrimeNumber(Integer number){
        // assumption: prime number cannot be negative
        if (number < 0) return false;

        boolean flag = false;
        for (int i = 2; i <= number / 2; ++i) {
            // condition for nonprime number
            if (number % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String args[]) {
        System.out.println(isPrimeNumber(-1));
        System.out.println(isPrimeNumber(-2));
        System.out.println(isPrimeNumber(-3));
        System.out.println(isPrimeNumber(20));
        System.out.println(isPrimeNumber(21));
        System.out.println(isPrimeNumber(23));
    }

}
