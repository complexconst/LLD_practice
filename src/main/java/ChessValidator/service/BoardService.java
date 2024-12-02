package ChessValidator.service;

import ChessValidator.ChessValidator;
import ChessValidator.entity.*;

import java.util.Map;

public class BoardService {
    Map<String, Piece> chessBoard;
    public static int pieceId;

    public BoardService(Map<String, Piece> chessBoard)  {
        this.chessBoard = chessBoard;
    }


    public void initializeBoard() {
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
                try {
                    chessBoard.put(position.toString(), piece);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public void showBoard() {
        for(Integer col = 8; col >= 1; col--) {
            for(Character row = 'a'; row <= 'h'; row++) {
                StringBuilder position = new StringBuilder(row.toString());
                position.append(col);
                try {
                    System.out.print(chessBoard.get(position.toString()).getName() + " ");
                }
                catch(NullPointerException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }


    public void executeMoveOnBoard(String startPosition, String endPosition) {
        Piece startingPeice, endingPeice;
        try {
            startingPeice = chessBoard.get(startPosition);
            endingPeice = chessBoard.get(endPosition);
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        chessBoard.remove(startPosition);
        chessBoard.remove(endPosition);

        Piece piece = new Piece(pieceId++, startPosition);
        startingPeice.setPosition(endPosition);

        chessBoard.put(endPosition, startingPeice);
        chessBoard.put(startPosition, piece);
    }
}
