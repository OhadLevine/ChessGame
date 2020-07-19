package ohad.levin.chess;

import java.util.ArrayList;

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

    public boolean hasEnemyPieces(int file, int row, boolean isWhite) {
        return true;
    }

    public boolean positionAttacked(int file, int row, boolean isWhite) {
        return true;
    }
}
