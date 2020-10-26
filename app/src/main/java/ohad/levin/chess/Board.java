package ohad.levin.chess;

import java.util.ArrayList;

import ohad.levin.chess.pieces.Piece;

public final class Board {
    private static Position[][] board;
    private static final int boardMinDimensions = 0;
    private static final int boardMaxDimensions = 8;

    private static ArrayList<Position> whiteAttackedPositions = new ArrayList<>();
    private static ArrayList<Position> blackAttackedPositions = new ArrayList<>();

    private Board() {
        throw new AssertionError("***** This is a utility class!!!! *******");
    }

    public static void createPositions(){
        for(int i = 0; i < boardMaxDimensions; i++) {
            for(int j = 0; j < boardMaxDimensions; j++) {
                board[i][j] = new Position(i, j);
            }
        }
    }

    public static Position getPosition(int file, int row) {
        return board[file][file];
    }

    /**
     * @param pos The position to check.
     * @return Is the board empty in a specified position.
     */
    public static boolean isEmpty(Position pos) {
        return board[pos.getFile()][pos.getRow()].isEmpty();
    }

    public static void addPiece(Position pos, Piece piece) {
        board[pos.getFile()][pos.getRow()].setPiece(piece);
    }

    public static void removePiece(Position pos) {
        board[pos.getFile()][pos.getRow()].setPiece(null);
    }

    /**
     * @param isWhite for knowing which color the enemy is.
     * @param pos     the position to check.
     * @return whether the specified position has enemy pieces.
     */
    public static boolean hasEnemyPiece(Position pos, boolean isWhite) {
        if (!board[pos.getFile()][pos.getRow()].isEmpty())
            return isWhite ? !board[pos.getFile()][pos.getRow()].getPiece().isWhite() : board[pos.getFile()][pos.getRow()].getPiece().isWhite();
        else return false;
    }

    public static void addAttackedPosition(Position pos, boolean isWhite) {
        if (isWhite) blackAttackedPositions.add(pos);
        else whiteAttackedPositions.add(pos);
    }

    public static void removeAttackedPosition(Position pos, boolean isWhite) {
        if (isWhite) blackAttackedPositions.remove(pos);
        else whiteAttackedPositions.remove(pos);
    }

    public static ArrayList<Position> getAttackedPositions(boolean isWhite) {
        return isWhite ? whiteAttackedPositions : blackAttackedPositions;
    }

    /**
     * @return whether a specified position is attacked.
     */
    public static boolean positionAttacked(Position pos, boolean isWhite) {
        return isWhite ? whiteAttackedPositions.contains(pos) : blackAttackedPositions.contains(pos);
    }

    public static Position[][] getBoard(){
        return board;
    }


    /**
     * @param fileOrRow specify whether you want to check if the file or the row exists.
     * @return does the file or row exist on the board.
     */
    public static boolean exists(int fileOrRow) {
        return fileOrRow > boardMinDimensions && fileOrRow <= boardMaxDimensions;
    }

    public static boolean exists(int file, int row) {
        return exists(row) && exists(file);
    }

    /**
     * This method is used for doing all the actions of every move, every piece class implements move methods for its specific cases.
     */
    public static void move(Piece piece, Position moveTo, boolean isWhite) {
        for (Position p : piece.possibleMoves())
            Board.removeAttackedPosition(p, isWhite);
        Board.removePiece(piece.getPosition());
        piece.setPosition(moveTo);
        Board.addPiece(piece.getPosition(), piece);
        for (Position p : piece.possibleMoves())
            Board.addAttackedPosition(p, isWhite);
    }
}
