package ChessValidator.service.Impl;

import ChessValidator.entity.Piece;
import ChessValidator.service.PieceValidatorService;

import java.util.Map;

import static java.lang.Math.abs;

public class QueenValidatorService extends PieceValidatorService {

    public QueenValidatorService(Map<String, Piece> chessBoard) {
        super(chessBoard);
    }

    @Override
    public Boolean validateMove(Integer move, String startPosition, String endPosition) {
        BishopValidatorService bishopValidatorService = new BishopValidatorService(chessBoard);
        RookValidatorService rookValidatorService = new RookValidatorService(chessBoard);

        Boolean isValidBishop = bishopValidatorService.validateMove(move, startPosition, endPosition);
        Boolean isValidRook = rookValidatorService.validateMove(move, startPosition, endPosition);

        if(isValidBishop || isValidRook){
            return true;
        }
        return false;
    }
}
