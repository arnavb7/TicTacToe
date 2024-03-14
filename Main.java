import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // while game state is ongoing
            // call print board
            // read input from scanner
            // call playturn
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the dimensions for the TicTacToe game.");
        int dimensions = in.nextInt();
        System.out.println("Welcome to " + dimensions + "x" + dimensions + " TicTacToe!");
        Game ticTacToe = new Game(dimensions);
        while (ticTacToe.getGameState() == GameState.ONGOING) {
            ticTacToe.printBoard();
            System.out.println("\nPlease enter the first coordinate.");
            int coord1 = in.nextInt();
            System.out.println("Please enter the second coordinate.");
            int coord2 = in.nextInt();
            ticTacToe.playTurn(coord1, coord2);
            ticTacToe.getGameState();
        }
        if (ticTacToe.getGameState() == GameState.X_WIN) {
            System.out.println("Player X won the game!");
        }
        else if (ticTacToe.getGameState() == GameState.O_WIN) {
            System.out.println("Player O won the game!");
        }
        else if (ticTacToe.getGameState() == GameState.DRAW) {
            System.out.println("Game was a draw!");
        }
        ticTacToe.printBoard();
    }
}
