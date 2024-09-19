package OOPS;
import java.util.*;
import java.util.function.Consumer;

public class LambdaExpressions implements lambda{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(i);
        }
        list.forEach(i -> System.out.println(i));
        Consumer<Integer> fun = i -> System.out.println(i+5);
        list.forEach(fun);
        lambda sum = (a, b) -> a + b;
        lambda prod = (a, b) -> a * b;
        lambda sub = (a, b) -> a - b;
        System.out.println();
        System.out.println(sum.operation(10,20));
        System.out.println(prod.operation(10,20));
        System.out.println(sub.operation(10,20));

        LambdaExpressions ab = new LambdaExpressions(10, 20);
        LambdaExpressions ba = ab;

        System.out.println(ba.num1);
        System.out.println(ba.num2);
    }

    int num1;
    int num2;

    public LambdaExpressions(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}

interface lambda {
    int operation(int a, int b);
}
