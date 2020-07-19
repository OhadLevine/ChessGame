package ohad.levin.chess.pieces;

import java.util.ArrayList;

import ohad.levin.chess.Constants;
import ohad.levin.chess.GameActivity;
import ohad.levin.chess.Position;

import static ohad.levin.chess.GameActivity.board;
public class King extends Piece {
    private static final int kKingsRookFile = 8;
    private static final int kQueensRookFile = 1;
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
        this(isWhite, isWhite ? Constants.DefaultPiecePositions.kWhiteKing : Constants.DefaultPiecePositions.kBlackKing);
    }

    /**
     * Creates a new king piece.
     *
     * @param isWhite Is the king white.
     * @param position The position where the king will be created.
     */
    King(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    @Override
    public ArrayList<Position> possibleMoves() {
        ArrayList<Position> positions = new ArrayList<>();
        for (int i = getPosition().getFile() - 1; i < kMoveArea; i++) {
            for (int j = getPosition().getRow() - 1; j < kMoveArea; j++) {
                if ((board.isEmpty(i, j) || board.hasEnemyPieces(i, j, isWhite)) && !board.positionAttacked(i, j, isWhite))
                    positions.add(new Position(i, j));
            }
        }
        if (canLongCastle()) positions.add(new Position(kLongCastleFile, getPosition().getRow()));
        if (canShortCastle()) positions.add(new Position(kShortCastleFile, getPosition().getRow()));
        return positions;
    }

    private boolean canLongCastle() {
        boolean isAttacked, isEmpty;
        for (int i = kQueensRookFile; i <= getDefaultPosition(isWhite).getFile(); i++) {
            isAttacked = board.positionAttacked(i, getDefaultPosition(isWhite).getRow(), isWhite);
            isEmpty = board.isEmpty(i, getDefaultPosition(isWhite).getRow());
            if (isAttacked || isEmpty || didMove) return false;
        }
        return true;
    }

    private boolean canShortCastle() {
        boolean isAttacked, isEmpty;
        for (int i = getDefaultPosition(isWhite).getFile(); i <= kKingsRookFile; i++) {
            isAttacked = board.positionAttacked(i, getDefaultPosition(isWhite).getRow(), isWhite);
            isEmpty = !board.isEmpty(i, getDefaultPosition(isWhite).getRow());
            if (isAttacked || isEmpty || didMove) return false;
        }
        return true;
    }

    @Override
    public void makeMove(Position toMove) {
        if (possibleMoves().contains(toMove)) {
            for (Position p : possibleMoves())
                board.removeFromAttackedSpots(p);
            setPosition(toMove);
            for (Position p : possibleMoves())
                board.addToAttackedSpots(p);
            this.didMove = true;
        } else {
            GameActivity.gameManager.alert("ILLEGAL MOVE! PLEASE TRY AGAIN!!!");
        }
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
