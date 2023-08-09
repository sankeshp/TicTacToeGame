package Models;

public class Board
{
    Player[][] cells;
    int dimensions;

    public Board(final int dimensions) {
        this.dimensions = dimensions;
        final Player[][] cells1 = new Player[dimensions][dimensions];
        for (int i = 0; i < dimensions; ++i) {
            for (int j = 0; j < dimensions; ++j) {
                cells1[i][j] = new Player();
            }
        }
        this.cells = cells1;
    }

    public Player[][] getCells() {
        return this.cells;
    }

    public void setCells(final Player[][] cells) {
        this.cells = cells;
    }

    public int getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(final int dimensions) {
        this.dimensions = dimensions;
    }
}