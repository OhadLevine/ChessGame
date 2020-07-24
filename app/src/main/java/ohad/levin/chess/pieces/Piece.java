package ohad.levin.chess.pieces;

import java.util.ArrayList;

import ohad.levin.chess.Position;

public abstract class Piece {

    /** @return all the possible moves for the specified piece in an array list. */
    public abstract ArrayList<Position> possibleMoves();

    /** Moves the piece to a specified location, and updates all the new attacked positions.
     * @param toMove The position to move the new piece to. */
    public abstract void makeMove(Position toMove);

    /** @return the default position of the piece. */
    public abstract Position getDefaultPosition(boolean isWhite);


    public abstract Position getPosition();

    public abstract void setPosition(Position position);
}
