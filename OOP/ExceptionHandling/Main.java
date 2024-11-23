package OOP.ExceptionHandling;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Are you ? ");
            boolean areYouTringToShutDown = s.nextBoolean();
            if (areYouTringToShutDown) {
                throw new MyException("Nahh we don't do that here");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyException extends Exception {
    MyException (String message) {
        super(message);
    }
}

