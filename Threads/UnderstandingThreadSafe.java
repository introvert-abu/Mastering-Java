package Threads;

public class UnderstandingThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable objA = () -> { 
            for (int i = 0; i < 1000000; i++) {
                c.increament();
            } 
        };
        
        Runnable objB = () -> {
            for (int i = 0; i < 1000000; i++) {
                c.increament();
            }
        };

        Thread t1 = new Thread(objA);
        Thread t2 = new Thread(objB);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.getCount());
    }
}

class  Counter {
    private int count;

    public synchronized int getCount() {
        return this.count;
    }

    // Threadsafe which means only one thread can access this at a time
    public synchronized void increament() {
        this.count++;
    }
}