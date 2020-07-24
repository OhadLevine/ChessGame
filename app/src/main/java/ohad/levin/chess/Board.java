package ohad.levin.chess;

import java.util.ArrayList;

import ohad.levin.chess.pieces.King;

public final class Board {
    private static final int boardMinDimensions = 0;
    private static final int boardMaxDimensions = 8;

    private static ArrayList<Position> whiteAttackedPositions = new ArrayList<>();
    private static ArrayList<Position> blackAttackedPositions = new ArrayList<>();
    private static ArrayList<Position> whitePositions = new ArrayList<>();
    private static ArrayList<Position> blackPositions = new ArrayList<>();

    private Board() {
        throw new AssertionError("***** This is a utility class!!!! *******");
    }

    /**
     * @param pos The position to check.
     * @return Is the board empty in a specified position.
     */
    public static boolean isEmpty(Position pos) {
        return whitePositions.contains(pos) || blackPositions.contains(pos);
    }

    public static void addPieceInPosition(Position pos, boolean isWhite) {
        if (isWhite) whitePositions.add(pos);
        else blackPositions.add(pos);
    }

    public static void removePieceInPosition(Position pos, boolean isWhite) {
        if (isWhite) whitePositions.remove(pos);
        else blackPositions.remove(pos);
    }

    /**
     * @param isWhite for knowing which color the enemy is.
     * @param pos     the position to check.
     * @return whether the specified position has enemy pieces.
     */
    public static boolean hasEnemyPieces(Position pos, boolean isWhite) {
        return isWhite ? blackPositions.contains(pos) : whitePositions.contains(pos);
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


    /**
     * @param fileOrRow specify whether you want to check if the file or the row exists.
     * @return does the specified file or row exist on the board.
     */
    public static boolean exists(int fileOrRow) {
        return fileOrRow > boardMinDimensions && fileOrRow <= boardMaxDimensions;
    }

    public static boolean exists(int file, int row) {
        return exists(row) && exists(file);
    }
}
