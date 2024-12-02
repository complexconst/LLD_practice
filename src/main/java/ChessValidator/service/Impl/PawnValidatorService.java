package ChessValidator.service.Impl;

import ChessValidator.entity.Piece;
import ChessValidator.service.PieceValidatorService;

import java.util.Map;

import static java.lang.Math.abs;

public class PawnValidatorService extends PieceValidatorService {

    public PawnValidatorService(Map<String, Piece> chessBoard) {
        super(chessBoard);
    }

    @Override
    public Boolean validateMove(Integer move, String startPosition, String endPosition) {
        Character row1 = startPosition.charAt(0);
        Character row2 = endPosition.charAt(0);
        Character startingPeiceColor = chessBoard.get(startPosition).getName().charAt(0);


        int col1 = Integer.parseInt(startPosition.substring(1));
        int col2 = Integer.parseInt(endPosition.substring(1));

        if(row1.equals(row2)) {
            Boolean isFirstMove = (move <= 1);
            int canPawnMoveTwice = 0;
            if(isFirstMove) {
                canPawnMoveTwice++;
            }
            if(abs(col2 - col1) <= 1 + canPawnMoveTwice) return true;
            return false;
        }
        if(abs(row1 - row2) == 1 && abs(col1 - col2) == 1) {
            if(startingPeiceColor == 'W') {
                if(col2 > col1) return true;
                return false;
            }
            if(startingPeiceColor == 'B') {
                if(col2 < col1) return true;
                return false;
            }
        }
        return false;
    }
}
