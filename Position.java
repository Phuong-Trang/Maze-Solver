package hw4_20001983_NgoPhuongTrang.bai6_maze;

public class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equal(Position another) {
        return row == another.row && col == another.col;
    }
}
