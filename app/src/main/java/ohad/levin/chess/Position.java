package ohad.levin.chess;

public class Position {
    private int file;
    private int row;

    /**
     * This class saves a position on the board
     *
     * @param file The column of said position
     * @param row  The row of said position
     */
    Position(char file, int row) {
        this((int)file, row);
    }

    public Position(int file, int row) {
        this.row = row;
        this.file = file;
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

    @Override
    public String toString() {
        return getCharFile(file)+ row + "";
    }
}
