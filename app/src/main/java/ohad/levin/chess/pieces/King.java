package ohad.levin.chess.pieces;

import ohad.levin.chess.Constants;
import ohad.levin.chess.Position;

public class King extends Piece {
    private Position position;
    private boolean isWhite;

    /**
     * Creates a new king piece.
     */
    public King(boolean isWhite) {
        this(isWhite, isWhite ? Constants.DefaultPiecePositions.kWhiteKing : Constants.DefaultPiecePositions.kBlackKing);
    }

    public King(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    @Override
    public Position[] movablePlaces() {
        return new Position[0];
    }

    @Override
    public void move(Position toMove) {

    }

    @Override
    public void delete() {

    }

    @Override
    public Position getDefaultPosition(boolean isWhite) {
        return null;
    }

    @Override
    public void getPosition() {

    }

    @Override
    public void setPosition() {

    }

    @Override
    public void isWhite() {

    }
}
