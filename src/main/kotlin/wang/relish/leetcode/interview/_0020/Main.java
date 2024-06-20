package wang.relish.leetcode.interview._0020;

import java.util.*;

/**
 * 微信一面原题240619
 */
public class Main {
    private static final List<Character> LEFT = List.of('(', '[', '{');
    private static final List<Character> RIGHT = List.of(')', ']', '}');

    public static boolean isValid(String str) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            final char ch = str.charAt(i);
            if (LEFT.indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || ch != RIGHT.get(LEFT.indexOf(stack.pop()))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int a = in.nextInt();
        // System.out.println(a);
        System.out.println(isValid("()")); // true
        System.out.println(isValid("{[()]}")); // true
        System.out.println(isValid("(")); // false
        System.out.println(isValid("{(]}")); // false
    }
}
