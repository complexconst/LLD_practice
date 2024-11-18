package SnakeAndLadder;

import SnakeAndLadder.entities.Board;
import SnakeAndLadder.entities.Player;

import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Board board = new Board(6, 100);
        Scanner sc = new Scanner(System.in);
        int numberOfSnakes = sc.nextInt();
        for(int snake = 0; snake < numberOfSnakes; snake++) {
            int head = sc.nextInt(), tail = sc.nextInt();
            board.AddSnake(head, tail);
        }

        int numberOfLadders = sc.nextInt();
        for(int ladder = 0; ladder < numberOfLadders; ladder++) {
            int head = sc.nextInt(), tail = sc.nextInt();
            board.AddLadder(head, tail);
        }


        Player player1 = new Player(1, "Alice");
        Player player2 = new Player(2, "Bob");

        int turn = 0;
        Boolean running = true;
        while(running) {
            Player curPlayer;
            if(turn % 2 == 0) {
                curPlayer = player1;
            }
            else {
                curPlayer = player2;
            }
            int diceNum = board.GetNum();
            System.out.print(curPlayer.getName() + " rolled a ");


            System.out.print(diceNum + " and moved from " + curPlayer.getCurPosition() + " to ");


            int newPos = board.ExecuteTurn(diceNum, curPlayer.getCurPosition());

            System.out.println(newPos);
            curPlayer.setCurPosition(newPos);

            running = board.getResult(newPos);

            if(!running) {
                curPlayer.Won();
            }
            turn++;
        }

    }
}