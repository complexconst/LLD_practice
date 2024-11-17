package org.example.entities;

import java.util.Random;

public class Dice {
    private int max_num;
    Dice(int max_num) {
        this.max_num = max_num;
    }

    Integer GetNumber() {
        Random rand = new Random();
        return rand.nextInt(max_num) + 1;
    }
}
