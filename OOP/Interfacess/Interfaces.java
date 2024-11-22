public class Interfaces implements A, B {

    @Override
    public void ABC() {
        System.out.println("I am from both interface A and B");
    }

    @Override
    public void BCD() {
        System.out.println("I am from both interface A and B");
    }

    @Override
    public void CDE() {
        System.out.println("I am from both interface A and B");
    }
    
    public static void main(String[] args) {
        Interfaces in = new Interfaces();
        in.ABC();
        in.BCD();
        in.CDE();
    }
}

interface A {
    abstract void ABC(); 
    abstract void BCD(); 
    abstract void CDE(); 
}

interface B {
    abstract void ABC(); 
    abstract void BCD(); 
    abstract void CDE();     
}
