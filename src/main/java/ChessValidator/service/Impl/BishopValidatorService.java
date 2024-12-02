package ChessValidator.service.Impl;

import ChessValidator.ChessValidator;
import ChessValidator.entity.Piece;
import ChessValidator.service.PieceValidatorService;

import java.util.Map;
import java.util.Objects;

import static java.lang.Math.*;
import static java.util.Collections.swap;


public class BishopValidatorService extends PieceValidatorService {

    public BishopValidatorService(Map<String, Piece> chessBoard) {
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

        Integer col3;
        Character row3;
        if(col1 > col2) {
            col3 = col1;
            col1 = col2;
            col2 = col3;
            row3 = row1;
            row1 = row2;
            row2 = row3;
        }
        if(abs(row1 - row2) == abs(col1 - col2) && !startingPeice.getColor().equals(endingPeice.getColor())) {
            int cnt = abs(row1-row2);
            for(int i = 1; i < cnt; i++) {
                Integer col = col1 + i;
                Character row = (char)(row1 + i);
                if(row < row2) {
                    StringBuilder builder = new StringBuilder(row.toString());
                    builder.append(col);
                    if(!Objects.equals(chessBoard.get(builder.toString()).getName(), "--")) {
                        return false;
                    }
                }
                row = (char)(row1 - i);
                if(row > row2) {
                    StringBuilder builder = new StringBuilder(row.toString());
                    builder.append(col);
                    if(!Objects.equals(chessBoard.get(builder.toString()).getName(), "--")) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
