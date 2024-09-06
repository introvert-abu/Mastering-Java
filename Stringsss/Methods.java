package Stringsss;

import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        // Just remember Strings are immutable
        String name = "Abubakker Siddik";
        String naam = String.valueOf("Abubakker Siddik");
        String s = "str";

        // hashcode is basically like an heap address all objects has a hashcode
        // because in java we cannot get the memory address so an integer is derived
        // from the memory address that is called hashcode
        // This is code .equals method checks also
        System.out.println(name.hashCode());
        System.out.println(naam.hashCode());
        System.out.println(s.hashCode());

        System.out.println(name.charAt(0)); // Like accessing via index
        System.out.println(name.codePointAt(0)); // Acsii value of that index
        System.out.println(name.codePointBefore(1)); // Ascii value for element before that index
        System.out.println(name.codePointCount(8, 16)); // counts how many elements are between the indeices
        System.out.println(name.concat(s)); // Concats of course
        System.out.println(name.contains("A")); // Searches of course
        System.out.println(name.contentEquals(naam)); // Checks whther the content in that string is equals or not
        System.out.println(name.endsWith("k")); // Of course You know
        System.out.println(name.indexOf("A")); // Of course You know
        System.out.println(name.isEmpty()); // just how it looks like
        System.out.println(name.lastIndexOf("i")); // just how it looks like
        System.out.println(name.repeat(2)); // just how it looks like
        System.out.println(name.replace("i", "j")); // just how it looks like
        System.out.println(name.replaceAll("A.u", "abu")); // supports regex
        System.out.println(name.replaceFirst("i", "o")); // just how it looks like
        System.out.println(String.valueOf("\u2003Hello World!\u2003").strip()); // Removes unwanted white spaces even
                                                                                // the unicode
        System.out.println(String.valueOf("\u2003Hello World\u2003").trim()); // Does not work with unicode
        System.out.println(Arrays.toString(name.split(""))); // spilits string by the given regex
        System.out.println(Arrays.toString(name.split(" "))); // spilits string by the given regex
        String[] arr = { "Hello", "World" };
        System.out.println(String.join("", arr)); // Like python
        name.chars().forEach(ch -> System.out.println((char)(ch))); // returns the Intstream (ascii) of every char
    }
}
