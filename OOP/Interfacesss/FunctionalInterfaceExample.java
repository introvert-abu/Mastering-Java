package OOP.Interfacesss;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Fun w = (a, b) -> a + b;
        System.out.println(w.doMath(1, 2));
        Fun x = (a, b) -> a - b;
        System.out.println(x.doMath(1, 2));
        Fun y = (a, b) -> a * b;
        System.out.println(y.doMath(1, 2));
        Fun z = (a, b) -> a / b;
        System.out.println(z.doMath(1, 2));
    }
}

@FunctionalInterface
interface Fun {
    public abstract int doMath(int a, int b);
}