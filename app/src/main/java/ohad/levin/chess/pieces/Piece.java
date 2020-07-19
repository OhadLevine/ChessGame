package ohad.levin.chess.pieces;

import java.util.ArrayList;

import ohad.levin.chess.Position;

public class Piece {
    private boolean isWhite;
    private Position position;

    protected Piece(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    public ArrayList<Position> possibleMoves() {
        return null;
    }

    public void makeMove(Position toMove) {
    }

    public void delete() {}

    public Position getDefaultPosition(boolean isWhite) { return null; }

    public Position getPosition() { return null; }

    public void setPosition(Position position) {}

    public boolean isWhite() { return this.isWhite; }
}
