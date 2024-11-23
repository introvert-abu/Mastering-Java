package Threads;

public class ThreadWithThreadClass {
    public static void main(String[] args) {
        A objA = new A();
        B objB = new B();

        objA.setPriority(Thread.MAX_PRIORITY);

        objA.start();
        objB.start();
    }
}

class A extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Bye");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
