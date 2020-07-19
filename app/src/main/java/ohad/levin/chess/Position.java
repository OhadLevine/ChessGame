package ohad.levin.chess;

public class Position {
    private char file;
    private int row;

    Position(char file, int row) {
        this.row = row;
        this.file = file;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getFile() {
        return file;
    }

    public void setFile(char file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", file=" + file +
                '}';
    }
}
