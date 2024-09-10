package Leetcode.Recursion.Easy;

public class NumOfStepsToReduceToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(12));
    }

    static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    static int helper(int n, int c){
        if (n == 0) {
            return c;
        }
        if ((n & 1) != 1) {
            return helper(n/2,++c);
        }
        return helper(n-1,++c);
    }

}
