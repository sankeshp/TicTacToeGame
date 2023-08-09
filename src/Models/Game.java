package Models;

import java.util.List;

public class Game
{
    Board board;
    List<Player> playerList;
    GameStatus gameStatus;
    int currentPlayerIndex;

    public Game(final Board board, final List<Player> playerList, final int currentPlayerIndex) {
        this.board = board;
        this.playerList = playerList;
        this.gameStatus = GameStatus.Running;
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(final Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public void setPlayerList(final List<Player> playerList) {
        this.playerList = playerList;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public void setGameStatus(final GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getCurrentPlayerIndex() {
        return this.currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(final int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void checkWinner() {
        final Player[][] cells = this.board.getCells();
        final int dim = cells.length;
        final Player currentPlayer = this.getPlayerList().get(this.currentPlayerIndex);
        for (int i = 0; i < dim; ++i) {
            int cnt = 0;
            for (int j = 0; j < dim; ++j) {
                if (cells[i][j].equals(currentPlayer)) {
                    ++cnt;
                }
            }
            if (cnt == dim) {
                this.setGameStatus(GameStatus.Won);
                return;
            }
        }
        for (int i = 0; i < dim; ++i) {
            int cnt = 0;
            for (int j = 0; j < dim; ++j) {
                if (cells[j][i].equals(currentPlayer)) {
                    ++cnt;
                }
            }
            if (cnt == dim) {
                this.setGameStatus(GameStatus.Won);
                return;
            }
        }
        int cnt2 = 0;
        for (int k = 0; k < dim; ++k) {
            if (cells[k][k].equals(currentPlayer)) {
                ++cnt2;
            }
        }
        if (cnt2 == dim) {
            this.setGameStatus(GameStatus.Won);
            return;
        }
        cnt2 = 0;
        int l = 0;
        for (int j = dim - 1; j >= 0; --j) {
            if (cells[j][l].equals(currentPlayer)) {
                ++cnt2;
            }
            ++l;
        }
        if (cnt2 == dim) {
            this.setGameStatus(GameStatus.Won);
            return;
        }
        boolean isEmpty = false;
        for (int m = 0; m < dim; ++m) {
            for (int j2 = 0; j2 < dim; ++j2) {
                if (cells[m][j2].getPlayerType() == null) {
                    isEmpty = true;
                }
            }
        }
        if (!isEmpty) {
            this.setGameStatus(GameStatus.Tie);
        }
    }

    public void DisplayBoard() {
        final Player[][] cells = this.board.getCells();
        final int dim = cells.length;
        final Player currentPlayer = this.getPlayerList().get(this.currentPlayerIndex);
        System.out.println("Following board after move by:-" + currentPlayer.getName());
        for (int i = 0; i < dim; ++i) {
            for (int j = 0; j < dim; ++j) {
                if (cells[i][j].getPlayerType() == null) {
                    System.out.print("|-|");
                }
                else {
                    System.out.print("|" + cells[i][j].getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }

    public void nextMove() {
        final int playersCnt = this.playerList.size();
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % playersCnt;
    }
}