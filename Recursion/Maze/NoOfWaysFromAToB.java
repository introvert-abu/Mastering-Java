package Recursion.Maze;

import java.util.ArrayList;

public class NoOfWaysFromAToB {
    public static void main(String[] args) {
        // int[][] arr = new int[3][3];
        // System.out.println(findWays(arr, 0, 0));
        // ArrayList<String> ans = new ArrayList<>();
        // findWaysRet(ans, "", 2,2);
        // System.out.println(ans);
        // ArrayList<String> ans = new ArrayList<>();
        // findWaysDiagRet(ans, "", 3,3);
        // System.out.println(ans);
        boolean[][] board = new boolean[3][3];
        ArrayList<ArrayList<String>> main = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        allPaths(main, board, ans, "", 0, 0);
        for (int i = 0; i < main.size(); i++) {
            for (int j = 0; j < main.get(i).size(); j++) {
                System.out.println(main.get(i).get(j));
            }
            System.out.println(ans.get(i));
            System.out.println();
        }
    }

    static void allPaths(ArrayList<ArrayList<String>> main, boolean[][] board, ArrayList<String> result, String p, int r, int c){
        if (r == board.length-1 && c == board[0].length-1) {
            board[r][c] = true;
            ArrayList<String> ans = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j]) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                }
                ans.add(sb.toString());
            }
            main.add(ans);
            result.add(p);
            return;
        }

        if (board[r][c]) {
            return;
        }

        board[r][c] = true;
        if (r < board.length-1) {
            allPaths(main, board, result, p+'D', r+1, c);
        }
        if (c < board[0].length-1) {
            allPaths(main, board, result, p+'R', r, c+1);
        }
        if (r > 0) {
            allPaths(main, board, result, p+'U', r-1, c);
        }
        if (c > 0) {
            allPaths(main, board, result, p+'L', r, c-1);
        }

        board[r][c] = false;
    }

    static void findWaysDiagRet(ArrayList<String> result, String p, int r, int c){
        if (r == 1 && c == 1) {
            result.add(p);
            return;
        }
        if (r > 1 && c > 1) {
            findWaysDiagRet(result, p+'D', r-1, c-1);
        }
        if (r > 1) {
            findWaysDiagRet(result, p+'V', r-1, c);
        }
        if (c > 1) {
            findWaysDiagRet(result, p+'H', r, c-1);
        }
    }

    static void findWaysRet(ArrayList<String> result, String p, int r, int c){
        if (r == 0 || c == 0) {
            while (r > 0) {
                p += 'D';
                r--;
            }
            while (c > 0) {
                p += 'R';
                c--;
            }
            result.add(p);
            return;
        }
        findWaysRet(result, p+'D', r-1, c);
        findWaysRet(result, p+'R', r, c-1);
    }

    static int findWays(int[][] board, int r, int c){
        if (r == board.length-1 || c == board.length-1) {
            return 1;
        }
        int count = 0;

        count += findWays(board, r+1, c);
        count += findWays(board, r, c+1);

        return count;
    }
}