package ohad.levin.chess;

import ohad.levin.chess.pieces.Piece;

public class Position {
    private int file;
    private int row;
    private boolean isEmpty;
    private Piece piece;

    /**
     * This class saves a position on the board
     *
     * @param file The column of said position.
     * @param row  The row of said position.
     */
    Position(char file, int row) {
        this((int)file, row);
    }

    public Position(int file, int row) {
        this(file, row, null, true);
    }

    public Position(int file, int row, Piece piece, boolean isEmpty) {
        this.row = row;
        this.file = file;
        this.piece = piece;
        this.isEmpty = isEmpty;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getFile() {
        return file;
    }

    public void setFile(char file) {
        this.file = file;
    }

    public char getCharFile(int file) {
        return (char) (file + 65);
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void setEmpty(boolean empty){
        isEmpty = empty;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}