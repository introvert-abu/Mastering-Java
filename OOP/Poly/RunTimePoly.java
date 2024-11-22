package OOP.Poly;

public class RunTimePoly {
    public static void main(String[] args) {
        A obj = new A();
        obj.code();
        obj = new B();
        obj.code();
    }
}

class A {
    public void code() {
        System.out.println("A coding...");
    }
}

class B extends A {
    @Override
    public void code() {
        System.out.println("B coding...");
    }
}