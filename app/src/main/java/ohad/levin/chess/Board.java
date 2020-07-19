package ohad.levin.chess;

import java.util.ArrayList;

import ohad.levin.chess.pieces.King;

public class Board {
    private Position[][] squares;
    private ArrayList<Position> attackedSpots = new ArrayList<>();

    Board() {
        createPieces();
    }

    public boolean isEmpty(int file, int row) {
        return true;
    }

    private void createPieces() {
        King whiteKing = new King(true);

        King blackKing = new King(false);
    }

    public void addPiece(Position placeToAdd) {

    }

    public void removePiece(Position placeToRemove) {

    }

    public void addToAttackedSpots(Position position) {
        attackedSpots.add(position);
    }

    public void removeFromAttackedSpots(Position position) {
        attackedSpots.remove(position);
    }

    public ArrayList<Position> getAttackedSpots() {
        return attackedSpots;
    }

    public boolean hasEnemyPieces(int file, int row, boolean isWhite) {
        return true;
    }

    public boolean positionAttacked(int file, int row, boolean isWhite) {
        return true;
    }
}
