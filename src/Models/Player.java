package Models;

import java.util.Scanner;

public class Player
{
    int Id;
    String Name;
    char Symbol;
    PlayerType playerType;

    public Player(final int id, final String name, final char symbol, final PlayerType playerType) {
        this.Id = id;
        this.Name = name;
        this.Symbol = symbol;
        this.playerType = playerType;
    }

    public Player() {
        this.Id = -1;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(final int id) {
        this.Id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(final String name) {
        this.Name = name;
    }

    public char getSymbol() {
        return this.Symbol;
    }

    public void setSymbol(final char symbol) {
        this.Symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

    public void setPlayerType(final PlayerType playerType) {
        this.playerType = playerType;
    }

    public void makeMove(final Board board) {
        final Player[][] cells = board.getCells();
        final int dim = cells.length;
        final Scanner sc = new Scanner(System.in);
        System.out.println("Please enter move for player:-" + this.getName());
        System.out.println("Please enter row details");
        final int row = sc.nextInt();
        System.out.println("Please enter column details");
        final int col = sc.nextInt();
        if (row >= dim || col >= dim) {
            System.out.println("Invalid move. Please re-enter");
            this.makeMove(board);
            return;
        }
        if (cells[row][col].getPlayerType() == null) {
            cells[row][col] = this;
            return;
        }
        System.out.println("Cell provided by " + this.getName() + " is already filled. Please re-input details");
        this.makeMove(board);
    }
}