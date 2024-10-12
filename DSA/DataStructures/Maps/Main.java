package DSA.DataStructures.Maps;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hash.put(i, i);
            System.out.println(hash.get(i));
        }
    }    
}