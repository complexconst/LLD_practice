package ChessValidator.entity;

public class Pawn extends Piece {

    public Pawn(int id, String position, String color) {
        super(id, position);
        this.color = color;
        StringBuilder pieceName = new StringBuilder(color);
        pieceName.append("P");
        this.name = pieceName.toString();
    }
}
