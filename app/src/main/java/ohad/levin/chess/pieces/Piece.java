package ohad.levin.chess.pieces;

import java.util.ArrayList;

import ohad.levin.chess.Position;

public class Piece {
    protected Position position;
    protected boolean isWhite;

    public ArrayList<Position> moves() {
        return null;
    }

    public void move(Position toMove) {}

    public void delete() {}

    public Position getDefaultPosition(boolean isWhite) { return null; }

    public Position getPosition() { return null; }

    public void setPosition(Position position) {}

    public boolean isWhite() { return this.isWhite; }
}
