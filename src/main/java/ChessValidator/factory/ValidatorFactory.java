package ChessValidator.factory;

import ChessValidator.entity.Piece;
import ChessValidator.service.Impl.*;
import ChessValidator.service.PieceValidatorService;

import java.util.Map;

public class ValidatorFactory {

    Map<String, Piece> chessBoard;


    public ValidatorFactory(Map<String, Piece> chessBoard) {
        this.chessBoard = chessBoard;
    }


    public PieceValidatorService getValidatorService(String pieceName) {
        char pieceType = pieceName.charAt(1);
        switch (pieceType) {
            case 'B':
                return new BishopValidatorService(chessBoard);
                case 'P':
                    return new PawnValidatorService(chessBoard);
            case 'K':
                return new KingValidatorService(chessBoard);
            case 'N':
                return new KnightValidatorService(chessBoard);
            case 'Q':
                return new QueenValidatorService(chessBoard);
                case 'R':
                    return new RookValidatorService(chessBoard);
            default:
                return new PieceValidatorService(chessBoard);
        }
    }

}
