package com.mission.mars;

import com.mission.mars.utils.NumberUtils;

public class Grid {
    private int x;
    private int y;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Grid upper-coordinates: x = " + this.x + ", y = " + this.y);
    }

    public Boolean isValidMove(Integer x, Integer y){

        if (x > this.x || y > this.y){
            System.out.println("M - Cannot move to position (" + x + "," + y + ") as it exceeds the grid boundaries.");
            return false;
        }else if (x < 0 || y < 0){
            System.out.println("M - Cannot move to position (" + x + "," + y + ") as it exceeds the grid boundaries.");
            return false;
        }else if (NumberUtils.isPrimeNumber( x + y)) {
            System.out.println("M - Cannot move to position (" + x + "," + y + ") as (x+y) is a prime number.");
            return false;
        }else {
            return true;
        }
    }
}