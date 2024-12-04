package ChessValidator;

import ChessValidator.entity.*;
import ChessValidator.factory.ValidatorFactory;
import ChessValidator.service.BoardService;
import ChessValidator.service.PieceValidatorService;

import java.util.HashMap;
import java.util.Map;

public class ChessValidator {

    Map<String, Piece> chessBoard;
    PieceValidatorService validatorService;
    ValidatorFactory validatorFactory;
    BoardService boardService;

    public ChessValidator() {
        chessBoard = new HashMap<>();
        validatorFactory = new ValidatorFactory(chessBoard);
        boardService = new BoardService(chessBoard);
    }


    public void initialize() {
        boardService.initializeBoard();
    }


    void showChessBoard() {
        boardService.showBoard();
    }

    Boolean validateMove(int move, String startPosition, String endPosition) {
        String startingPeiceName, endingPeiceName;
        try {
            startingPeiceName = chessBoard.get(startPosition).getName();
            endingPeiceName = chessBoard.get(endPosition).getName();
        }
        catch(NullPointerException e) {
            e.printStackTrace();
            return false;
        }

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
        boardService.executeMoveOnBoard(startPosition, endPosition);
    }

}
