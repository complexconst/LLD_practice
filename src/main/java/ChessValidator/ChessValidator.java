package ChessValidator;

import ChessValidator.entity.*;
import ChessValidator.factory.ValidatorFactory;
import ChessValidator.service.PieceValidatorService;

import java.util.HashMap;
import java.util.Map;

public class ChessValidator {

    Map<String, Piece> chessBoard;
    public static int pieceId;
    PieceValidatorService validatorService;
    ValidatorFactory validatorFactory;

    public ChessValidator() {
        chessBoard = new HashMap<>();
        validatorFactory = new ValidatorFactory(chessBoard);
    }


    public void initialize() {
        for(Character row = 'a'; row <= 'h'; row++) {
            for(Integer col = 8; col >= 1; col--) {
                String color = "B";
                if(col <= 4) color = "W";
                Piece piece = null;
                StringBuilder position = new StringBuilder(row.toString());
                position.append(col);
                if(col == 7 || col == 2) {
                    piece = new Pawn(pieceId++, position.toString(), color);
                }
                else {
                    if(col == 1 || col == 8) {
                        if(row == 'a' || row == 'h') {piece = new Rook(pieceId++, position.toString(), color);}
                        if(row == 'b' || row == 'g') {piece = new Knight(pieceId++, position.toString(), color);}
                        if(row == 'c' || row == 'f') {piece = new Bishop(pieceId++, position.toString(), color);}
                        if(row == 'd') {piece = new Queen(pieceId++, position.toString(), color);}
                        if(row == 'e') {piece = new King(pieceId++, position.toString(), color);}
                    }
                    else {
                        piece = new Piece(pieceId++, position.toString());
                    }
                }
                chessBoard.put(position.toString(), piece);
            }
        }
    }


    void showChessBoard() {
        for(Integer col = 8; col >= 1; col--) {
            for(Character row = 'a'; row <= 'h'; row++) {
                StringBuilder position = new StringBuilder(row.toString());
                position.append(col);
                System.out.print(chessBoard.get(position.toString()).getName() + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    Boolean validateMove(int move, String startPosition, String endPosition) {
        System.out.println(startPosition + " " + endPosition);
        String startingPeiceName = chessBoard.get(startPosition).getName();
        String endingPeiceName = chessBoard.get(endPosition).getName();

        if(startingPeiceName.charAt(0) == endingPeiceName.charAt(0)) {
            return false;
        }
        char idealMove = 'B';
        if(move % 2 == 0) {
            idealMove = 'W';
        }
        if(startingPeiceName.charAt(0) != idealMove) {
            return false;
        }

        validatorService = validatorFactory.getValidatorService(startingPeiceName);

        Boolean isValid =  validatorService.validateMove(move, startPosition, endPosition);

        if(isValid) {
            executeMove(startPosition, endPosition);
            showChessBoard();
        }
        return isValid;
    }

    void executeMove(String startPosition, String endPosition) {
        System.out.println(chessBoard.get("f1").getName());
        Piece startingPeice = chessBoard.get(startPosition);
        Piece endingPeice = chessBoard.get(endPosition);
        chessBoard.remove(startPosition);
        chessBoard.remove(endPosition);

        Piece piece = new Piece(ChessValidator.pieceId++, startPosition);
        startingPeice.setPosition(endPosition);

        chessBoard.put(endPosition, startingPeice);
        chessBoard.put(startPosition, piece);
    }

}
