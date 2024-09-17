package Recursion.Mazes;

import java.util.ArrayList;

public class MazeWithObstracles {
    public static void main(String[] args) {
        // System.out.println(pathsToTargetObstracles("", 0, 0));
        boolean[][] board = {
                { true, true, true },
                { false, false, true },
                { true, true, true }
        };
        System.out.println(pathsToTargetObstraclesWithArray("", 0, 0, board));
    }

    static ArrayList<String> pathsToTargetObstraclesWithArray(String p, int r, int c, boolean[][] board) {
        ArrayList<String> list = new ArrayList<>();
        if (r == board.length - 1 && c == board[0].length - 1) {
            list.add(p);
            return list;
        }
        if (!board[r][c]) {
            return list;
        }
        if (r < board.length - 1) {
            list.addAll(pathsToTargetObstraclesWithArray(p + "D", r + 1, c, board));
        }
        if (c < board[0].length - 1) {
            list.addAll(pathsToTargetObstraclesWithArray(p + "R", r, c + 1, board));
        }

        return list;
    }
}