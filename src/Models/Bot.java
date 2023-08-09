package Models;

import java.util.Random;

public class Bot extends Player
{
    public Bot(final int id, final String name, final char symbol, final PlayerType playerType) {
        super(id, name, symbol, playerType);
    }

    public void makeMove(final Board board) {
        final Player[][] cells = board.getCells();
        final int dim = cells.length;
        final Random random = new Random();
        final int row = random.nextInt(dim);
        final int col = random.nextInt(dim);
        System.out.println(row + "-" + col);
        if (cells[row][col].getPlayerType() == null) {
            cells[row][col] = this;
        }
        else {
            this.makeMove(board);
        }
    }
}