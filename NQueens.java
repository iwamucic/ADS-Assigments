

public class NQueens {
    private int[][] chessboard;
    private int size;

    public NQueens(int n) {
        size = n;
        chessboard = new int[n][n];
    }

    public boolean solve() {
        return solutionNQueens(0);
    }

    private boolean solutionNQueens(int col) {
        if (col >= size) {
            return true; // All queens are placed
        }

        for (int row = 0; row < size; row++) {
            if (isItSafe(row, col)) {
                chessboard[row][col] = 1; // Place queen

                printBoard();

                // Place rest of queens on the board
                if (solutionNQueens(col + 1)) {
                    return true;
                }

                chessboard[row][col] = 0; // Backtrack
            }
        }
        return false; // No solution exists
    }

    private boolean isItSafe(int row, int col) { //function for checking queen conditions
        // Check row
        for (int i = 0; i < col; i++) {
            if (chessboard[row][i] == 1) {
                return false;
            }
        }

        // Check left upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        // Check left lower diagonal
        for (int i = row, j = col; i < size && j >= 0; i++, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }

        return true; // No conflicts
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(chessboard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        int N = 8; // Board size
        NQueens nQueens = new NQueens(N);
        if (nQueens.solve()) {
            System.out.println("Solution Found:");
            nQueens.printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
