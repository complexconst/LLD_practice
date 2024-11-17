package org.example.SnakeAndLadder.entities;

import java.util.HashMap;

public class Board {
    Integer maxRows;
    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;
    Dice dice;

    public Board(int maxNum, int maxRows) {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        dice = new Dice(maxNum);
        this.maxRows = maxRows;
    }

    public void AddSnake(int x, int y) {
        snakes.put(x, y);
    }

    public void AddLadder(int x, int y) {
        ladders.put(x, y);
    }

    public Integer GetNum() {
        return dice.GetNumber();
    }

    public Integer ExecuteTurn(int diceNum, int curPosition) {
        int initPos = curPosition;

        curPosition += diceNum;

        if(snakes.containsKey(curPosition)) {
            curPosition = snakes.get(curPosition);
        }

        if(ladders.containsKey(curPosition)) {
            curPosition = ladders.get(curPosition);
        }

        if(curPosition > 100) {
            curPosition = initPos;
        }

        return curPosition;
    }

    public Boolean getResult(int position) {
        if(position == maxRows) {
            return false;
        }
        return true;
    }

}
