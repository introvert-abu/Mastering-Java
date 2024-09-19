package OOPS;

// Interfaces are introduced in order to fill the gap of multiple inheritance
// Interfaces contains only public abstract functions and public static final variables
// abstract function is just a function with only name and does not contain any body 
// Classes those implements these functions(I mean Interface) must override those functions
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
