package ChessValidator.entity;

public class Rook extends Piece {
    public Rook(int id, String position, String color) {
        super(id, position);
        this.color = color;
        StringBuilder pieceName = new StringBuilder(color);
        pieceName.append("R");
        this.name = pieceName.toString();
    }
}
