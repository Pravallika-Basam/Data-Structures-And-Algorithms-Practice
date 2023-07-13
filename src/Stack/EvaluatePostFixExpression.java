package Stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * This program evaluates a postfix expression and returns its value.
 * It supports the operators: +, -, *, /, ^.
 * The input expression is provided as a string in postfix notation.
 * The output is the evaluated value of the expression.
 */
public class EvaluatePostFixExpression {

    static final Set<String> operators = new HashSet<>();

    public static void main(String[] args) {

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        operators.add("^");

        // Input expression in postfix notation
        // String postFix = "10 2 * 3 +";
        // String postFix = "10 2 + 3 *";
        // String postFix = "10 2 3 ^ ^";
        String postFix = "10 2 * 3 5 * + 9 -";

        // Evaluate the postfix expression
        Long value = evaluatePostFix(postFix);
        System.out.println("Postfix expression value is " + value);
    }

    /**
     * Evaluates a postfix expression and returns its value.
     *
     * @param postFix The input expression in postfix notation
     * @return The evaluated value of the expression
     */
    private static Long evaluatePostFix(String postFix) {
        String[] arr = postFix.split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (!operators.contains(arr[i])) {
                stack.push(arr[i]); // Push operands to the stack
            } else {
                Long b = Long.valueOf(stack.pop()); // Pop the second operand from the stack
                Long a = Long.valueOf(stack.pop()); // Pop the first operand from the stack
                Long result = performOperation(a, b, arr[i]); // Perform the operation and get the result
                stack.push(String.valueOf(result)); // Push the result back to the stack
            }
        }
        return Long.valueOf(stack.pop()); // The final value left in the stack is the evaluated result
    }

    /**
     * Performs the specified operation on the given operands and returns the result.
     *
     * @param a        The first operand
     * @param b        The second operand
     * @param operator The operator to perform the operation
     * @return The result of the operation
     */
    private static Long performOperation(Long a, Long b, String operator) {
        if (operator.equals("+")) {
            return a + b; // Addition operation
        } else if (operator.equals("-")) {
            return a - b; // Subtraction operation
        } else if (operator.equals("*")) {
            return a * b; // Multiplication operation
        } else if (operator.equals("/")) {
            return a / b; // Division operation
        } else {
            return (long) Math.pow(a, b); // Exponentiation operation
        }
    }
}
