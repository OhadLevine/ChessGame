package ohad.levin.chess.pieces;

import ohad.levin.chess.Position;

public class Piece {
    Position position;
    int rating;
    boolean isWhite;

    public Piece() {}

    public Position[] movablePlaces() {
        return null;
    }

    public void move(Position toMove) {}

    public void delete() {}

    public Position getDefaultPosition(boolean isWhite) { return null; }

    public void getPosition() {}

    public void setPosition() {}

    public void isWhite() {}
}
