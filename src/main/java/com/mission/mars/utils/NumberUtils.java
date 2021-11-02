package com.mission.mars.utils;

public class NumberUtils {

    public static Boolean isPrimeNumber(Integer number){

        // Wikipedia: A prime number (or a prime) is a natural number greater than 1 that is not a product of two smaller natural numbers.
        if (number < 2) return false;

        boolean flag = false;
        for (int i = 2; i <= number / 2; ++i) {
            // condition for non-prime number
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
