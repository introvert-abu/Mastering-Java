package OOP;

public class Human implements Cloneable {
    String name;
    int age;
    int salary;
    String company;
    int[] arr;

    public Human(String name, int age, String company, int salary, int[] arr) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.salary = salary;
        this.arr = arr;
    }

    // This will do deep copy
    public Human(Human other) {
        this.name = other.name;
        this.age = other.age;
        this.company = other.company;
        this.salary = other.salary;
        this.arr = new int[other.arr.length];
        for (int i = 0; i < other.arr.length; i++) {
            this.arr[i] = other.arr[i];
        }
    }

    // This will do shallow copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
