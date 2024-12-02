package ChessValidator.entity;

public class Queen extends Piece {
    public Queen(int id, String position, String color) {
        super(id, position);
        this.color = color;
        StringBuilder pieceName = new StringBuilder(color);
        pieceName.append("Q");
        this.name = pieceName.toString();
    }
}
