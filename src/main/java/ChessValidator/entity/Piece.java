package ChessValidator.entity;

public class Piece {
    int id;
    String position;
    String color;
    String name;

    public Piece(int id, String position) {
        this.id = id;
        this.position = position;
        this.name = "--";
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
