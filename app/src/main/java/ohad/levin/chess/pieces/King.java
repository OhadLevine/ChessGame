package ohad.levin.chess.pieces;

import java.util.ArrayList;

import ohad.levin.chess.Board;
import ohad.levin.chess.Position;

public class King extends Piece {
    private static final int kQueensRookFile = 1;
    private static final int kKingsRookFile = 8;
    private static final int kLongCastleFile = 3;
    private static final int kShortCastleFile = 7;
    private static final int kMoveArea = 3;


    private boolean didMove = false;
    private boolean isWhite;
    private Position position;

    /**
     * Creates a new king piece.
     */
    public King(boolean isWhite) {
        this(isWhite, isWhite ? Board.getPosition(5, 1) : Board.getPosition(5, 8));
    }

    /**
     * Creates a new king piece.
     *
     * @param isWhite  Is the king white.
     * @param position The position where the king will be created.
     */
    King(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
        Board.addPiece(position, this);
    }

    @Override
    public ArrayList<Position> possibleMoves() {
        ArrayList<Position> positions = new ArrayList<>();
        for (int i = getPosition().getFile() - 1; i < kMoveArea; i++) {
            for (int j = getPosition().getRow() - 1; j < kMoveArea; j++) {
                if (!Board.exists(i, j)) continue;
                if ((Board.isEmpty(Board.getPosition(i, j)) || Board.hasEnemyPiece(Board.getPosition(i, j),
                        isWhite)) && !Board.positionAttacked(Board.getPosition(i, j), isWhite))
                    positions.add(Board.getPosition(i, j));
            }
        }
        if (canLongCastle())
            positions.add(Board.getPosition(kLongCastleFile, getPosition().getRow()));
        if (canShortCastle())
            positions.add(Board.getPosition(kShortCastleFile, getPosition().getRow()));
        return positions;
    }

    private boolean canLongCastle() {
        for (int i = kQueensRookFile; i <= getDefaultPosition(isWhite).getFile(); i++)
            if (!isLegalCastlingPos(Board.getPosition(i, getDefaultPosition(isWhite).getRow())))
                return false;
        return true;
    }

    private boolean canShortCastle() {
        for (int i = getDefaultPosition(isWhite).getFile(); i <= kKingsRookFile; i++)
            if (!isLegalCastlingPos(Board.getPosition(i, getDefaultPosition(isWhite).getRow())))
                return false;
        return true;
    }

    private boolean isLegalCastlingPos(Position pos) {
        return !Board.positionAttacked(pos, isWhite) &&
                Board.isEmpty(pos) && !didMove;
    }

    public boolean isInCheck() {
        return Board.getAttackedPositions(isWhite).contains(getPosition()) ? true : false;
    }

    @Override
    public void makeMove(Position toMove) {
        Board.move(this, toMove, isWhite);
        this.didMove = true;
    }

    @Override
    public Position getDefaultPosition(boolean isWhite) {
        return isWhite ? Board.getPosition(5, 1) : Board.getPosition(5, 8);
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
        return isWhite;
    }
}
