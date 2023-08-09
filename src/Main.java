import Models.GameStatus;
import java.util.List;
import Models.Game;
import Models.Board;
import Models.Bot;
import Models.PlayerType;
import Models.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] args) {
        System.out.println("Welcome to Tic tac toe game");
        System.out.println("Please enter no of players");
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Please provide dimension for a Board");
        final int boardDimension = sc.nextInt();
        System.out.println("Do you want to play with Bot");
        final String botRequired = sc.next();
        n = ((botRequired.equals("y") || botRequired.equals("Y")) ? (n - 1) : n);
        final List<Player> playerList = new ArrayList<Player>();
        for (int i = 0; i < n; ++i) {
            System.out.println("Please enter details for a player " + i);
            System.out.println("Please enter player name");
            final String name = sc.next();
            System.out.println("Please enter player symbol");
            final String symbol = sc.next();
            playerList.add(new Player(i, name, symbol.charAt(0), PlayerType.Human));
        }
        if (botRequired.equals("y") || botRequired.equals("Y")) {
            System.out.println("Please enter details for a Bot");
            System.out.println("Please enter Bot name");
            final String name2 = sc.next();
            System.out.println("Please enter Bot symbol");
            final String symbol2 = sc.next();
            playerList.add((Player)new Bot(n - 1, name2, symbol2.charAt(0), PlayerType.Bot));
        }
        final Board board = new Board(boardDimension);
        final Game gameObj = new Game(board, (List)playerList, 0);
        while (gameObj.getGameStatus().equals((Object)GameStatus.Running)) {
            final int currentPlayerIndex = gameObj.getCurrentPlayerIndex();
            final Player currentPlayer = gameObj.getPlayerList().get(currentPlayerIndex);
            currentPlayer.makeMove(gameObj.getBoard());
            gameObj.DisplayBoard();
            gameObj.checkWinner();
            if (gameObj.getGameStatus().equals((Object)GameStatus.Won)) {
                System.out.println("Congratulation player:-" + currentPlayer.getName() + " for winning game");
                break;
            }
            if (gameObj.getGameStatus().equals((Object)GameStatus.Tie)) {
                System.out.println("Unfortunately game has been tie. Please play again");
                break;
            }
            gameObj.nextMove();
        }
    }
}