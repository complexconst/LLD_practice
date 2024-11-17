package org.example.entities;

public class Player {
    private static int id;
    private String name;
    private int curPosition;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        curPosition = 0;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCurPosition() {
        return curPosition;
    }

    public void setCurPosition(int curPosition) {
        this.curPosition = curPosition;
    }


    public void Won() {
        System.out.println(this.name + "  wins the game");
    }
}
