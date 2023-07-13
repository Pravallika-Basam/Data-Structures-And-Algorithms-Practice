package Stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * This program converts an infix expression to prefix notation.
 * It supports the operators: +, -, *, /, ^ and parentheses ().
 * The input expression is provided as a string in infix notation.
 * The output is the equivalent expression in prefix notation.
 */
public class InFixtoPrefix {

    // Map to store the supported operators and their precedence values for comparison
    // Operators with lower values have lower precedence.
    static final Map<Character, Integer> operators = new HashMap<>();

    public static void main(String[] args) {
        // Add supported operators and their precedence values for comparison to the map
        operators.put('+', 1);
        operators.put('-', 1);
        operators.put('*', 2);
        operators.put('/', 2);
        operators.put('^', 3);
        operators.put('(', 0);
        operators.put(')', 0);

        // Input expression in infix notation
        String infix = "(a+b)*(c-d)";

        // Convert the input expression to prefix notation
        String preFix = getPreFix(infix, infix.length());
        System.out.println("Prefix expression is " + preFix);
    }

    /**
     * Converts an infix expression to prefix notation.
     *
     * @param infix The input expression in infix notation
     * @param n     The length of the input expression
     * @return The equivalent expression in prefix notation
     */
    private static String getPreFix(String infix, int n) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        // Process each character in the input expression from right to left
        for (int i = n - 1; i >= 0; i--) {
            char chr = infix.charAt(i);
            if (!operators.containsKey(chr)) {
                output.append(chr); // Append operands directly to the output
                System.out.println("Output is " + output);
            } else {
                if (chr == ')') {
                    stack.push(chr); // Push ')' to the stack
                } else if (chr == '(') {
                    while (stack.peek() != ')') {
                        output.append(stack.pop()); // Pop operators from the stack and append them to the output until '(' is encountered
                        System.out.println("Output is " + output);
                    }
                    stack.pop(); // Discard the '(' from the stack
                    System.out.println("Stack is " + stack);
                } else if (!stack.isEmpty() && isLessPrecedence(chr, stack.peek())) {
                    // Pop operators from the stack and append them to the output as long as the current operator
                    // has lower precedence than the top of the stack
                    while (!stack.isEmpty() && isLessPrecedence(chr, stack.peek())) {
                        output.append(stack.pop());
                        System.out.println("Output is " + output);
                        System.out.println("Stack is " + stack);
                    }
                    stack.push(chr); // Push the current operator to the stack
                    System.out.println("Stack is " + stack);
                } else {
                    stack.push(chr); // Push the current operator to the stack
                    System.out.println("Stack is " + stack);
                }
            }
        }

        // Append any remaining operators from the stack to the output
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        System.out.println("Stack is " + stack);
        return output.reverse().toString(); // Reverse the output to get the prefix notation
    }

    /**
     * Checks if the precedence of the current operator is less than or equal to the precedence of the operator on top of the stack.
     *
     * @param chr  The current operator
     * @param peek The operator on top of the stack
     * @return True if the current operator has lower or equal precedence, False otherwise
     */
    public static boolean isLessPrecedence(Character chr, Character peek) {
        System.out.println("char is " + chr + " peek " + peek);
        return operators.get(chr) <= operators.get(peek);
    }
}
