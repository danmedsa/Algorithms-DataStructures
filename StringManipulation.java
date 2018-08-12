package com.danielmedina;


import java.lang.reflect.Array;
import java.util.HashMap;

import static java.lang.System.out;

public class StringManipulation {
    private String str;

    public StringManipulation(String str) {
        out.println("--- StringManipulation Initialized with String: " + str + " ---");
        this.str = str;
    }


    public void traverseChars() {
        out.println("--- Traversing Characters ---");
        StringBuilder newStr = new StringBuilder();
        for (char ch : this.str.toCharArray()) {
            System.out.print(ch);
        }
    }

    static Boolean isPalindrome(String s) {
        out.println("--- Validating Palindrome: '" + s + "' ---");
        for (int i = 0; i < s.length()/2; i++) {
            int last = s.length() - 1 - i;

            if (s.charAt(i) != s.charAt(last)) {
                return false;
            }
        }
        return true;
    }
}
