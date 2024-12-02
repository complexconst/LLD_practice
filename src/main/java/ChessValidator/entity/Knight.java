package ChessValidator.entity;

public class Knight extends Piece {
    public Knight(int id, String position, String color) {
        super(id, position);
        this.color = color;
        StringBuilder pieceName = new StringBuilder(color);
        pieceName.append("N");
        this.name = pieceName.toString();
    }
}
