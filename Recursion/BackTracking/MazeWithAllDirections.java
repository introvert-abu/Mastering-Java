package Recursion.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeWithAllDirections {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        int[][] path = new int[maze.length][maze[0].length];
        paths(maze, "", 0, 0, path, 1);
    }

    static void paths(boolean[][] maze, String p, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int i = 0; i < path.length; i++) {
                System.out.println(Arrays.toString(path[i]));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            paths(maze, p + "D", r + 1, c, path, step + 1);
        }
        if (c < maze[0].length - 1) {
            paths(maze, p + "R", r, c + 1, path, step + 1);
        }
        if (r > 0) {
            paths(maze, p + "U", r - 1, c, path, step + 1);
        }
        if (c > 0) {
            paths(maze, p + "L", r, c - 1, path, step + 1);
        }
        maze[r][c] = true;
        path[r][c] = 0;
    }

    static int count = 0;

    static ArrayList<String> paths(boolean[][] maze, String p, int r, int c) {
        ArrayList<String> list = new ArrayList<>();
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            list.add(p + " - " + count);
            return list;
        }
        if (!maze[r][c]) {
            return list;
        }
        count++;
        maze[r][c] = false;
        if (r < maze.length - 1) {
            list.addAll(paths(maze, p + "D", r + 1, c));
        }
        if (c < maze[0].length - 1) {
            list.addAll(paths(maze, p + "R", r, c + 1));
        }
        if (r > 0) {
            list.addAll(paths(maze, p + "U", r - 1, c));
        }
        if (c > 0) {
            list.addAll(paths(maze, p + "L", r, c - 1));
        }
        maze[r][c] = true;
        count--;
        return list;
    }
}
