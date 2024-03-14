import java.sql.SQLOutput;

public class Game {
    private char[][] board;
    private GameState gameState;
    private boolean isXTurn;
    private int dimension;

    public Game(int dimension) {
        this.board = new char[dimension][dimension];
        this.isXTurn = true;
        this.dimension = dimension;
    }

    public void printBoard() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if ((i == dimension - 1) && (j == dimension - 1)) {
                    System.out.println(board[i][j]);
                }
                else if (j == dimension - 1) {
                    System.out.println(board[i][j] + "\n" + "---------------");
                }
                else if ((i == 0) && (j == 0)) {
                    System.out.print("\n" + board[i][j] + " | ");
                }
                else {
                    System.out.print(board[i][j] + " | ");
                }
            }
        }
    }

    public GameState getGameState() {
        if (this.checkWin('X')) {
            return GameState.X_WIN;
        }
        else if (this.checkWin('O')) {
            return GameState.O_WIN;
        }
        else if (this.checkDraw()) {
            return GameState.DRAW;
        }
        else {
            return GameState.ONGOING;
        }
    }

    public void playTurn(int c1, int c2) {
        if ((c1 - 1 >= dimension) || (c2 - 1 >= dimension)) {
            System.out.println("Error, please retype your coordinates.");
            return;
        }
        if (!(board[c2 - 1][c1 - 1] == 0)) {
            System.out.println("Invalid placement, please retype your coordinates.");
            return;
        }
        if (isXTurn) {
            board[c2 - 1][c1 - 1] = 'X';
        }
        else {
            board[c2 - 1][c1 - 1] = 'O';
        }
        this.isXTurn = !this.isXTurn;
    }

    public boolean checkWin(char c) {
        int[] sums = new int[dimension * 2 + 2];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == c) {
                    sums[i]++;
                    sums[j + dimension]++;
                    if (i == j) {
                        sums[dimension * 2]++;
                    }
                    if (i + j == dimension - 1) {
                        sums[dimension * 2 + 1]++;
                    }
                }
            }
        }
        for (int count = 0; count < 8; count++) {
            if (sums[count] == dimension) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}


