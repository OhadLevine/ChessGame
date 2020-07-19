package ohad.levin.chess.pieces;

import java.util.ArrayList;

import ohad.levin.chess.Constants;
import ohad.levin.chess.Position;

import static ohad.levin.chess.MainActivity.board;

public class King extends Piece {
    private Position position;
    private boolean isWhite;

    /**
     * Creates a new king piece.
     */
    public King(boolean isWhite) {
        this(isWhite, isWhite ? Constants.DefaultPiecePositions.kWhiteKing : Constants.DefaultPiecePositions.kBlackKing);
    }

    /**
     * Creates a new king piece.
     *
     * @param isWhite Is the king white.
     * @param position The position where the king will be created.
     */
    King(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public ArrayList<Position> possibleMoves() {
        ArrayList<Position> positions = new ArrayList<>();
        for (int i = getPosition().getFile() - 1; i < 3; i++) {
            for (int j = getPosition().getRow() - 1; j < 3; j++) {
                if ((board.isEmpty(i, j) || board.hasEnemyPieces(isWhite)) && !board.positionAttacked(isWhite))
                    positions.add(new Position(i, j));
            }
        }
        if (canLongCastle()) positions.add(new Position(getPosition().getFile(), getPosition().getRow() + 2));
        if (canShortCastle()) positions.add(new Position(getPosition().getFile(), getPosition().getRow() - 2));
        return null;
    }

    private boolean canLongCastle() {
        return true;
    }

    private boolean canShortCastle() {
        return true;
    }

    @Override
    public void makeMove(Position toMove) {

    }

    @Override
    public void delete() {

    }

    @Override
    public Position getDefaultPosition(boolean isWhite) {
        return isWhite ? Constants.DefaultPiecePositions.kWhiteKing : Constants.DefaultPiecePositions.kBlackKing;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean isWhite() {
        return this.isWhite;
    }
}
