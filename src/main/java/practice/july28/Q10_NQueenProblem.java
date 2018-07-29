package practice.july28;

public class Q10_NQueenProblem {
    int N;

    public Q10_NQueenProblem(int pN) {
        N = pN;
    }

    public static void main(String[] args) {
        Q10_NQueenProblem problem = new Q10_NQueenProblem(4);
        problem.solveNQueen();
    }

    boolean isSafe(int[][] pBoard, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (pBoard[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (pBoard[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (pBoard[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    boolean solveNQUtil(int[][] board, int col) {
        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    boolean solveNQueen() {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
        solveNQUtil(board, 0);
        printBoard(board);
        return true;
    }

    void printBoard(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
