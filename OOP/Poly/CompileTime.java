package OOP.Poly;

public class CompileTime {

    static void add(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    static void add(int n1, int n2, int n3) {
        System.out.println(n1 + n2 + n3);
    }

    static void add(int n1, int n2, int n3, int n4) {
        System.out.println(n1 + n2 + n3 + n4);
    }

    public static void main(String[] args) {
        add(1, 2);
        add(1, 2,3);
        add(1, 2,3,4);
    }
}
