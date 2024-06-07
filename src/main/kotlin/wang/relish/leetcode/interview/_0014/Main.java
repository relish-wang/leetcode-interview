package wang.relish.leetcode.interview._0014;

/**
 * 当时用Java手写的, 出现好几处语法问题。整体思路没问题，能AC。
 */
public class Main {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(f(strs));
    }

    public static String f(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            if (strs[0].length() <= i) break;
            char cur = strs[0].charAt(i);
            boolean flag = false; // 需要跳出循环
            for (String str : strs) {
                if (str.length() <= i) {
                    flag = true;
                    break;
                }
                if (str.charAt(i) != cur) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                sb.append(cur);
                i++;
            }
        }
        return sb.toString();
    }
}