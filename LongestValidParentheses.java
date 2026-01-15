import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "((()))())";

        System.out.println( s1  + longestValidParentheses(s1));
        System.out.println( s2  + longestValidParentheses(s2));
        System.out.println( s3 + longestValidParentheses(s3));
    }
}
