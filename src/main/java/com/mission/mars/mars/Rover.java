package com.mission.mars.mars;

public class Rover {

    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    private Integer x = 0;
    private Integer y = 0;
    private Integer direction = N;
    private String commands;

    public Rover() {
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public char getDirection(Integer dir) {
        char direction = 'N';
        if (dir == 1) {
            direction = 'N';
        } else if (dir == 2) {
            direction = 'E';
        } else if (dir == 3) {
            direction = 'S';
        } else if (dir == 4) {
            direction = 'W';
        }
        return direction;
    }

    public void setCommands(String commands){
        this.commands = commands;
    }

    public String getCommands(){
        return this.commands;
    }

    public void setPosition(Integer x, Integer y, Integer direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void displayPosition() {
        System.out.println("Position: " + x + " " + y + " " + getDirection(direction));
    }

    public void process(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            start(commands.charAt(i));
        }
    }

    public void travel() {
        for (int i = 0; i < this.commands.length(); i++) {
            start(this.commands.charAt(i));
        }
    }

    private void start(Character command) {
        if (command.equals('L')) {
            System.out.println("L - Spin left");
            spinLeft(); // spin 90 degrees
            spinLeft(); // spin 90 degrees
        } else if (command.equals('R')) {
            System.out.println("R - Spin right");
            spinRight(); // spin 90 degrees
            spinRight(); // spin 90 degrees
        } else if (command.equals('M')) {
//            if (!Utilities.isPrimeNumber(x + y)) {
//                System.out.println("M - Step forward");
                stepForward();
//            } else {
//                System.out.println("M - Cannot move to position (" + x + "," + y + ") as (x+y) is a prime number.");
//            }
        } else {
            throw new IllegalArgumentException(
                    "Speak in Mars language, please!");
        }
        displayPosition();
    }

    private void stepForward() {
        if (direction == N) {
            if (!Utilities.isPrimeNumber( x + (y+1))) {
                this.y++;
                System.out.println("M - Step forward");
            }else{
                System.out.println("M - Cannot move to position (" + x + "," + (y+1) + ") as (x+y) is a prime number.");
            }
        } else if (direction == E) {
            if (!Utilities.isPrimeNumber( (x+1) + y)) {
                this.x++;
                System.out.println("M - Step forward");
            }else{
                System.out.println("M - Cannot move to position (" + (x+1) + "," + y + ") as (x+y) is a prime number.");
            }
        } else if (direction == S) {
            if (!Utilities.isPrimeNumber( x + (y-1))) {
                this.y--;
                System.out.println("M - Step forward");
            }else{
                System.out.println("M - Cannot move to position (" + x + "," + (y-1) + ") as (x+y) is a prime number.");
            }
        } else if (direction == W) {
            if (!Utilities.isPrimeNumber( (x-1) + y)) {
                this.x--;
                System.out.println("M - Step forward");
            }else{
                System.out.println("M - Cannot move to position (" + (x-1) + "," + y + ") as (x+y) is a prime number.");
            }
        }
    }

    private void spinLeft() {
        // if direction is North and need to spin left, set direction to West
        direction = (direction - 1) < N ? W : direction - 1;
    }

    private void spinRight() {
        // if direction is West and need to spin right, set direction to North
        direction = (direction + 1) > W ? N : direction + 1;
    }

    public static void main(String args[]) {
        Rover rover1 = new Rover();
        Rover rover2 = new Rover();

        rover1.setPosition(1, 2, N);
        rover1.displayPosition();
        rover1.process("LMLMLMLMM");
        rover1.displayPosition(); // prints 1 3 N

        rover2.setPosition(3, 3, E);
        rover2.displayPosition();
        rover2.process("MMRMMRMRRM");
        rover2.displayPosition(); // prints 5 1 E
    }

}