package Stack;

import java.util.ArrayDeque;
import java.util.HashMap;

public class BalancedParenthesis {

    // Define the mapping of opening and closing brackets
    static final HashMap<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        //System.out.println(map);
        String input = "))";
        boolean b = isBalanced(input);
        System.out.println(b);

    }

    /**
     * Checks if the given opening and closing brackets are a matching pair.
     *
     * @param input The input String
     * @return True if the brackets are a matching pair, false otherwise
     */
    private static boolean isBalanced(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                // Opening bracket encountered, push it onto the stack
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    // Closing bracket encountered, check if it matches the top of the stack
                    Character pop = stack.pop();
                    if (map.get(c) != pop) {
                        // Mismatched brackets, return false
                        return false;
                    }
                } else {
                    // Closing bracket encountered but no opening bracket on the stack, return false
                    return false;
                }
            }
        }
        // All brackets are balanced if the stack is empty
        return stack.isEmpty();
    }
}
