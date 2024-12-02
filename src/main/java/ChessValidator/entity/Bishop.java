package ChessValidator.entity;

public class Bishop extends Piece {
    public Bishop(int id, String position, String color) {
        super(id, position);
        this.color = color;
        StringBuilder pieceName = new StringBuilder(color);
        pieceName.append("B");
        this.name = pieceName.toString();
    }
}
