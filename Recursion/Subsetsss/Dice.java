package Recursion.Subsetsss;

public class Dice {
    public static void main(String[] args) {
        diceCombos("", 7);
    }

    static void diceCombos (String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <=6 && i <= target; i++) {
            diceCombos(p + i, target - i);
        }
    } 
}
