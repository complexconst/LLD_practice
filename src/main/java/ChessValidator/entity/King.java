package ChessValidator.entity;

public class King extends Piece {
    public King(int id, String position, String color) {
        super(id, position);
        this.color = color;
        StringBuilder pieceName = new StringBuilder(color);
        pieceName.append("K");
        this.name = pieceName.toString();
    }
}
