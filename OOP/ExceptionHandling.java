package OOP;

public class ExceptionHandling {
    public static void main(String[] args) {
        String b = "";
        try {
            b = "a";
            throw new MyException("This exception is created by me");
            // int a = 2 / 0;
            // System.out.println(a);
            // throw new Exception("Just for fun");
        } catch (ArithmeticException e) {
            b = "b";
            System.out.println(e);
        } catch (Exception e) {
            b = "b";
            System.out.println(e);
        } finally {
            if (b == "b") {
                System.out.println("Error Found");
            } else {
                System.out.println("Looks Good to me");
            }
        }
    }

    static int sum (int a, int b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("Don't try to divide by zero");
        }
        return a / b;
    } 
}
