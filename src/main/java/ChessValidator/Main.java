package ChessValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ChessValidator chessValidator = new ChessValidator();

        chessValidator.initialize();

        chessValidator.showChessBoard();


        Scanner scanner = new Scanner(System.in);

        int move = 0;
        while(true) {
            String input = scanner.nextLine();

            String[] positions = input.split(" ");

            if(positions[0] == "exit") break;
            if(positions.length < 2) continue;

            Boolean isValid = chessValidator.validateMove(move, positions[0], positions[1]);

            if(isValid) {
                move++;
            }
            else {
                System.out.println("Invalid move");
            }

        }

    }
}
