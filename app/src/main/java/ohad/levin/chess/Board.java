package ohad.levin.chess;

import java.util.ArrayList;

import ohad.levin.chess.pieces.King;

public final class Board {
    private static ArrayList<Position> whiteAttackedPositions = new ArrayList<>();
    private static ArrayList<Position> blackAttackedPositions = new ArrayList<>();
    private static ArrayList<Position> whitePositions = new ArrayList<>();
    private static ArrayList<Position> blackPositions = new ArrayList<>();

    private Board() {
    }

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

    public static boolean positionAttacked(Position pos, boolean isWhite) {
        return isWhite ? whiteAttackedPositions.contains(pos) : blackAttackedPositions.contains(pos);
    }
}
