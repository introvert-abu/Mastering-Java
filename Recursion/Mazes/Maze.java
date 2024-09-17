package Recursion.Mazes;
import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        // System.out.println(noOfPaths(3, 3));
        // System.out.println(pathsToTarget("",3, 3));
        // System.out.println(pathsToTargetOpti("",3, 3));
        System.out.println(pathsToTargetDiagonal("",3, 3));
    }

    static ArrayList<String> pathsToTargetDiagonal (String p, int r, int c) {
        ArrayList<String> list = new ArrayList<>();
        if (r == 1 && c == 1) {
            list.add(p);
            return list;
        }
        if (c > 1 && r > 1) {
            list.addAll(pathsToTargetDiagonal(p + "D" , r-1, c-1));                        
        }
        if (r > 1) {
            list.addAll(pathsToTargetDiagonal(p + "V", r-1, c));
        }
        if (c > 1) {
            list.addAll(pathsToTargetDiagonal(p + "H" , r, c-1));            
        }
       
        return list;
    } 

    static ArrayList<String> pathsToTargetOpti (String p, int r, int c) {
        ArrayList<String> list = new ArrayList<>();
        if (r == 1 && c == 1) {
            list.add(p);
            return list;
        }
        if (r > 1) {
            ArrayList<String> left = pathsToTargetOpti(p + "D ", r-1, c);
            list.addAll(left);
        }
        if (c > 1) {
            ArrayList<String> right = pathsToTargetOpti(p + "R " , r, c-1);            
            list.addAll(right);
        }
       
        return list;
    } 

    static ArrayList<String> pathsToTarget (String p, int r, int c) {
        if (r == 1 || c == 1) {
            ArrayList<String> list = new ArrayList<>();
            if (r == 1) {
                for (int i = c; i > 1; i--) {
                    p = p + "R ";
                }                
            } else {
                for (int i = r; i > 1; i--) {
                    p = p + "D ";
                }                
            }
            list.add(p);
            return list;
        }
        ArrayList<String> left = pathsToTarget(p + "D ", r-1, c);
        ArrayList<String> right = pathsToTarget(p + "R " , r, c-1);

        left.addAll(right);        
        return left;
    } 

    static int noOfPaths (int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = noOfPaths(r-1, c); // going down
        int right = noOfPaths(r, c-1); // right
        // int rd = noOfPaths(r - 1, c - 1); // down + right || right + down

        return left + right;
    } 
}