public class SetTheBitTo1 {
    public static void main(String[] args) {
        byte a = (byte)(127 + 130);
        System.out.println(a);
        int n = 5;
        setTheBit(n, 2);
        resetTheBit(n, 1);
    }
    
    static void setTheBit(int n, int i) {
        n |= (1 << (i - 1));
        System.out.println(n);
    }

    static void resetTheBit(int n,int i) {
        n &= ~(1 << (i - 1));
        System.out.println(n);
    }
}
