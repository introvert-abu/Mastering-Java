package Recursion.BackTracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        // System.out.println(placeKnights(board, 0));
        System.out.println(placeKnights2(board, 0, 0, n));
    }

    static int placeKnights2(boolean[][] board, int row, int col, int n) {
        if (n == 0) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        if (row == board.length - 1 && col == board.length) {
            return count;
        }

        if (col == board.length) {
            count += placeKnights2(board, row + 1, 0, n);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += placeKnights2(board, row, col + 1, n - 1);
            board[row][col] = false;
        }
        count += placeKnights2(board, row, col + 1, n);

        return count;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && col >= 0 && row < board.length && col < board.length) {
            return true;
        }
        return false;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) return false;
        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) return false;
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) return false;
        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) return false;

        return true;
    }

    static int placeKnights(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += placeKnights(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
