package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        int fact = 10;
        System.out.println(doubleExpression(0.1, 0.2, 0.3));
        System.out.println(flipBit(222, 2));
        System.out.println(charExpression(29));
        System.out.println(isPowerOfTwo(-129));
        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.out.println("factorial of " + fact + " " + factorial(fact));
        int[] a1 = {-1, 3, 3, 6, 9, 10, 11, 12};
        int[] a2 = {0, 2, 4, 6, 8, 13, 14, 15};
        System.out.println("[1,3,5,7,9,10,11,12] + [0,2,4,6,8,13,14,15] = " + Arrays.toString(mergeArrays(a1, a2)));
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич", "Пётр"};
        String[] text = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                "Лука Лукич : Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, text));
    }

    /**
     * You are given a list of roles and a script for the play in the form of an array of lines.
     *
     * @param roles     role of person
     * @param textLines text of person
     * @return string text of role
     */

    public static String printTextPerRole(String[] roles, String[] textLines) {
        // use StringBuilder for optimal work with text
        StringBuilder result = new StringBuilder();

        // map for each replic
        Map<String, StringBuilder> roleLines = new HashMap<>();

        // init map
        for (String role : roles) {
            roleLines.put(role, new StringBuilder());
        }

        // each string of scenario
        for (int i = 0; i < textLines.length; i++) {
            String line = textLines[i];
            // look for ':'
            int colonIndex = line.indexOf(":");
            if (colonIndex == -1) {
                continue;
            }

            String role = line.substring(0, colonIndex).trim();
            String text = line.substring(colonIndex + 1);

            if (roleLines.containsKey(role)) {
                roleLines.get(role).append((i + 1) + ")" + text + "\n");
            }
        }

        // prepare final text
        for (String role : roles) {
            result.append(role).append(":\n");
            result.append(roleLines.get(role));
            result.append("\n");
        }

        // remove last \n
        if (!result.isEmpty() && result.charAt(result.length() - 1) == '\n') {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        List<Integer> resultList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a1.length || j < a2.length) {
            if (i >= a1.length) {
                resultList.add(a2[j]);
                j++;
                continue;
            } else if (j >= a2.length) {
                resultList.add(a1[i]);
                i++;
                continue;
            }
            if (a1[i] == a2[j]) {
                resultList.add(a1[i]);
                resultList.add(a2[j]);
                j++;
                i++;
            } else if (a1[i] > a2[j]) {
                resultList.add(a2[j]);
                j++;
            } else {
                resultList.add(a1[i]);
                i++;
            }
        }
        int[] result = new int[resultList.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = resultList.get(k);
        }
        return result;
    }

    public static BigInteger factorial(int value) {
        BigInteger result = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        boolean result = false;
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        text = text.toLowerCase();
        int middle = text.length() / 2 + 1;
        for (int i = 0; i < middle; i++) {
            int ukLast = text.length() - i - 1;
            if (i == ukLast || i > ukLast) {
                return true;
            }
            if (text.charAt(i) != text.charAt(ukLast)) {
                return false;
            }
        }
        return result;
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        value = value > 0 ? value : ~value + 1;
        if (value == 0 || value == 1) {
            return true;
        }

        if (value % 2 == 0) {
            return isPowerOfTwo(value / 2);
        }
        return false;
    }

    public static char charExpression(int a) {
        char symbol = '\\';
        return (char) (symbol + a);
    }

    public static int flipBit(int value, int bitIndex) {
        System.out.println(value + " " + bitIndex);
        value ^= 1 << bitIndex;
        return value;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        System.out.println(Math.abs(a) + Math.abs(b) - Math.abs(c));
        return Math.abs(Math.abs(a) + Math.abs(b) - Math.abs(c)) < 0.0001;
    }
}

