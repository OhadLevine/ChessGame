package ohad.levin.chess;

/** This class is used to store all of the constants relating to the game */
public class Constants {

    public static class DefaultPiecePositions {
        public static final Position kWhiteKing = new Position('E', 8);

        public static final Position kDefaultBlackKingPosition = new Position('E', 1);
    }


    public static final class PieceRatings {
        public static final int kKing = 100;
        public static final int kQueen = 9;
        public static final int kRook = 5;
        public static final int kKnight = 3;
        public static final int kBishop = 3;
        public static final int kPawn = 1;
    }
}
