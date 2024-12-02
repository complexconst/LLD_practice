package ChessValidator.service;

import ChessValidator.entity.Piece;

import java.util.Map;

public class PieceValidatorService {

    protected Map<String, Piece> chessBoard;

    public PieceValidatorService(Map<String, Piece> chessBoard) {
        this.chessBoard = chessBoard;
    }


    public Boolean validateMove(Integer move, String startPosition, String endPosition) {
        return false;
    }

}
