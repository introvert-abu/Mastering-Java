package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;

public class FileHandling {
    public static void main(String[] args) {
        // try (FileReader fr = new FileReader("Notes.txt")) {
        // int letters = fr.read();
        // while (fr.ready()) {
        // System.out.print((char) letters);
        // letters = fr.read();
        // }
        // System.out.print((char) letters);
        // System.out.println();
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // }

        // try (BufferedReader bf = new BufferedReader(new FileReader("Notes.txt"))) {
        // while (bf.ready()) {
        // System.out.println(bf.readLine());
        // }
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // }

        // try (BufferedReader bf = new BufferedReader(new
        // InputStreamReader(System.in))) {
        // System.out.println(bf.readLine());
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // }

        // try (OutputStreamWriter os = new OutputStreamWriter(System.out)) {
        // os.write(97);
        // os.write(98);
        // os.write(10);
        // os.write("Hello World!");
        // os.write("\n");
        // char[] arr = "Hello World!".toCharArray();
        // os.write(arr);
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }

        // try (FileWriter fw = new FileWriter("Notes.txt", true)) {
        // fw.write(" This should be appended");
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }

        try {
            File fo = new File("Notes2.txt");
            fo.createNewFile();
            fo.delete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Notes2.txt"))) {
            bw.write("Hello I am a new file created by Java");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("Notes2.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            File fo = new File("Dummy.txt");
            fo.createNewFile();
            if (fo.delete()) {
                System.out.println(fo.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
