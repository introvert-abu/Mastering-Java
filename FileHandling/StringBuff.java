package FileHandling;

import java.util.Random;

public class StringBuff {
    public static void main(String[] args) {
        // The difference between StringBuffer and StringBuilder is SF if thread Safe
        // It wont allow any other thread while working with it

        StringBuffer buffer = new StringBuffer();

        Random r = new Random();

        for (int i = 0; i < 26; i++) {
            buffer.append((char) (97 + r.nextInt(26)));
        }

        System.out.println(buffer);
    }
}
