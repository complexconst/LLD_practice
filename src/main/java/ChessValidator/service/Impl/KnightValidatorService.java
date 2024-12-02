package ChessValidator.service.Impl;

import ChessValidator.entity.Piece;
import ChessValidator.service.PieceValidatorService;

import java.util.Map;

import static java.lang.Math.abs;

public class KnightValidatorService extends PieceValidatorService {
    public KnightValidatorService(Map<String, Piece> chessBoard) {
        super(chessBoard);
    }

    @Override
    public Boolean validateMove(Integer move, String startPosition, String endPosition) {

        Piece startingPeice = chessBoard.get(startPosition);
        Piece endingPeice = chessBoard.get(endPosition);
        Character row1 = startPosition.charAt(0);
        Character row2 = endPosition.charAt(0);

        Integer col1 = Integer.parseInt(startPosition.substring(1));
        Integer col2 = Integer.parseInt(endPosition.substring(1));

        if(abs(row1 - row2) == 2 && abs(col1 - col2) == 1) {
            return true;
        }
        if(abs(row1 - row2) == 1 && abs(col1 - col2) == 2) {
            return true;
        }
        return false;
    }
}
