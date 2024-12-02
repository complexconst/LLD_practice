package ChessValidator.service.Impl;

import ChessValidator.entity.Piece;
import ChessValidator.service.PieceValidatorService;

import java.util.Map;
import java.util.Objects;

import static java.lang.Math.*;

public class RookValidatorService extends PieceValidatorService {
    public RookValidatorService(Map<String, Piece> chessBoard) {
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

        if(abs(row1 - row2) == 0) {
            for(Integer col = min(col1, col2) + 1; col < max(col1, col2); col++) {
                StringBuilder builder = new StringBuilder(row1.toString());
                builder.append(col.toString());
                if(chessBoard.get(builder.toString()).getName() != "--") {
                    return false;
                }
            }
            return true;
        }
        if(abs(col1 - col2) == 0) {
            for(char row = (char) (min(row1, row2) + 1); row < max(row1, row2); row++) {
                StringBuilder builder = new StringBuilder(row);
                builder.append(col1.toString());
                if(!Objects.equals(chessBoard.get(builder.toString()).getName(), "--")) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
