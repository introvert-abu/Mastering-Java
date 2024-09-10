class OddOrEven {
    public static void main(String[] args) {
        System.out.println(isOdd(6));
    }

    static String isOdd(int n){
        return (n & 1) == 1 ? "Odd" : "Even"; 
    }
}