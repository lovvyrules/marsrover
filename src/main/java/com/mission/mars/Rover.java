package com.mission.mars;

import com.mission.mars.utils.CardinalPoints;
import com.mission.mars.utils.NumberUtils;

// A Mars rover is a motor vehicle that travels across the surface of the planet Mars upon arrival.
public class Rover {

    // upper-right coordinates of the plateau
    private Grid grid;

    // plateau coordinates
    private Integer x = 0;
    private Integer y = 0;

    // direction the rover is facing
    private Integer direction = CardinalPoints.N;

    // in order to control a rover, NASA sends a simple string of letters
    private String commands;

    public Rover(Grid grid) {
        this.grid = grid;
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

    // input: direction as integer
    // returns the cardinal point
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

    // set the x and y coordinates, and the direction the rover is facing
    public void setPosition(String position) {
        String[] pos = position.split("\\s+");

        this.x = Integer.parseInt(pos[0]);
        this.y = Integer.parseInt(pos[1]);

        switch(pos[2]) {
            case "N":
                this.direction = CardinalPoints.N;
                break;
            case "E":
                this.direction = CardinalPoints.E;
                break;
            case "S":
                this.direction = CardinalPoints.S;
                break;
            case "W":
                this.direction = CardinalPoints.W;
                break;
            default:
                // code block
        }
    }

    // output the x and y coordinates, and the direction the rover is facing
    public void displayPosition() {
        System.out.println("Position: " + x + " " + y + " " + getDirection(direction));
    }

    // uses the commands to travel the plateau
    public void travel() {
        for (int i = 0; i < this.commands.length(); i++) {
            start(this.commands.charAt(i));
        }
    }

    // spin left, spin right or step forward 1 grid point
    private void start(Character command) {
        if (command.equals('L')) {
            System.out.println("L - Spin left by 180 degrees");
            spinLeft(); // spin 90 degrees
            spinLeft(); // spin 90 degrees
        } else if (command.equals('R')) {
            System.out.println("R - Spin right by 180 degrees");
            spinRight(); // spin 90 degrees
            spinRight(); // spin 90 degrees
        } else if (command.equals('M')) {
                stepForward();
        } else {
            throw new IllegalArgumentException(
                    "Speak in Mars language, please!");
        }
        displayPosition();
    }

    // move forward by 1 grid point in the direction the rover is facing
    // however, the rover has an issue, it cannot move to a position where (X+Y) is a prime number ...
    // ... therefore that position will be skipped
    private void stepForward() {
        if (direction == CardinalPoints.N) {
            if (this.grid.isValidMove( x,  (y+1))) {
                this.y++;
                System.out.println("M - Step forward");
            }
        } else if (direction == CardinalPoints.E) {
            if (this.grid.isValidMove( (x+1), y)) {
                this.x++;
                System.out.println("M - Step forward");
            }
        } else if (this.direction == CardinalPoints.S) {
            if (this.grid.isValidMove( x, (y-1))) {
                this.y--;
                System.out.println("M - Step forward");
            }
        } else if (direction == CardinalPoints.W) {
            if (this.grid.isValidMove( (x-1), y)) {
                this.x--;
                System.out.println("M - Step forward");
            }
        }
    }

    // spin 90 degrees left without moving from its current spot
    private void spinLeft() {
        // if direction is North and need to spin left, set direction to West
        direction = (direction - 1) < CardinalPoints.N ? CardinalPoints.W : direction - 1;
    }

    // spin 90 degrees right without moving from its current spot
    private void spinRight() {
        // if direction is West and need to spin right, set direction to North
        direction = (direction + 1) > CardinalPoints.W ? CardinalPoints.N : direction + 1;
    }

}