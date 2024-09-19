package OOPS;

public class Notes {
    public static void main(String[] args) {
        Students[] student = new Students[5];
        // System.out.println(Arrays.toString(student));
        // student[0] = new Students();
        // student[0].rno = 21;
        // student[0].mark = 99.22f;
        // student[0].dept = "CS";
        // System.out.println(Arrays.toString(student));
        // System.out.println(student[0].dept);

        // Assigning values using Constuctor
        student[1] = new Students();
        student[2] = new Students(22, "CS", 99.2f);
        student[3] = new Students(student[2]);

        for (int i = 1; i <= 3; i++) {
            if (i == 3) {
                System.out.println("Copied from above Using constructor");
            }
            System.out.print(student[i].rno + " - ");
            System.out.print(student[i].mark + " - ");
            System.out.print(student[i].dept);
            System.out.println();
        }
    }
}


class Students {
    int rno;
    String dept;
    float mark;
    
    Students() {
        this.rno = 000;
        this.dept = "I am from no parameter constructor";
        this.mark = 98.9f;
    }

    Students(int rno, String dept, float m) {
        this.rno = rno;
        this.dept = dept;
        this.mark = m;
    }

    Students (Students other) {
        this.rno = other.rno;
        this.dept = other.dept;
        this.mark = other.mark;
    }
}
