package Threads;

public class ThreadWithRunnableInterafce {    
    public static void main(String[] args) {
        Runnable objA = () -> { 
            for (int i = 0; i < 100; i++) System.out.println("Hi"); 
        };
        
        Runnable objB = () -> {
            for (int i = 0; i < 100; i++) System.out.println("Bye");
        };

        Thread t1 = new Thread(objA);
        Thread t2 = new Thread(objB);

        t1.start();
        t2.start();
    }
}
