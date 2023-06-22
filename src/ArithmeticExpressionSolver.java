import java.util.Scanner;

public class ArithmeticExpressionSolver {
    public static double findNValue(String expression, double result){
        String[] parts = expression.split("[/*+-]");
        double value = result;
        for (String part : parts) {
            System.out.printf(part+" ");
        }
        for (String part : parts) {
            if (part.contains("n")) {
                char operator = getOperator(part);
                if (operator == '/') {
                    value = value * Double.parseDouble(part.replace("n", ""));
                } else if (operator == '*') {
                    value = value / Double.parseDouble(part.replace("n", ""));
                } else if (operator == '+') {
                    value = value - Double.parseDouble(part.replace("n", ""));
                } else if (operator == '-') {
                    value = value + Double.parseDouble(part.replace("n", ""));
                }
            } else {
                char operator = getOperator(part);
                if (operator == '/') {
                    value = value / Double.parseDouble(part);
                } else if (operator == '*') {
                    value = value * Double.parseDouble(part);
                } else if (operator == '+') {
                    value = value + Double.parseDouble(part);
                } else if (operator == '-') {
                    value = value - Double.parseDouble(part);
                }
            }
        }
        return 0.0;
    }
    private static char getOperator(String part) {
        char chr = 0;
        for (char c : part.toCharArray()) {
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                chr =c;
            }
        }
        return chr;
    }

    public static void main(String[] args) {
        String expression = "3/2.0*n";
        double result = 19;
        findNValue(expression,result);

        String[] parts = expression.split("[/*+-]");
        double value = result;
//        for (String part : parts) {
//            if (part.contains("n")) {
//                double number = Double.parseDouble(part.replaceAll("[^\\d.-]+", ""));
//                if (part.contains("*")) {
//                    value /= number;
//                } else if (part.contains("/")) {
//                    value *= number;
//                } else if (part.contains("+")) {
//                    value -= number;
//                } else if (part.contains("-")) {
//                    value += number;
//                }
//            }
//        }

        System.out.printf("The value of n is %.4f", value);
    }
}
