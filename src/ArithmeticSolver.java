import java.text.DecimalFormat;

public class ArithmeticSolver {
    public static double findValueOfN(String expression, double res) {
        String[] addArr = expression.split("\\+");
        String newExp = "";
        double result = res;

        // Iterate through the terms separated by '+'
        for (String addExp : addArr) {
            if (!addExp.contains("n")) {
                result -= solveExpression(addExp); // Subtract the expression value from the result
            } else {
                newExp = addExp; // Save the term containing 'n' for further processing
            }
        }

        // Check if 'n' is found after the '+' terms
        if (newExp.equals("n")) {
            return extracted(result); // Extract the result and return it
        }

        String[] subArray = newExp.split("-");

        boolean firstTerm = false;
        // Iterate through the terms separated by '-'
        for (String subExp : subArray) {
            if (subExp.contains("n")) {
                firstTerm = true; // Set the flag to indicate the first term containing 'n'
            }
            if (firstTerm) {
                if (!subExp.contains("n")) {
                    result += solveExpression(subExp); // Add the expression value to the result
                } else {
                    newExp = subExp; // Save the term containing 'n' for further processing
                }
                firstTerm = false;
            } else {
                if (!subExp.contains("n")) {
                    result = solveExpression(subExp) - result; // Subtract the result from the expression value
                } else {
                    newExp = subExp; // Save the term containing 'n' for further processing
                }
            }
        }

        // Check if 'n' is found after the '-' terms
        if (newExp.equals("n")) {
            return extracted(result); // Extract the result and return it
        }

        String[] mulArray = newExp.split("\\*");

        // Iterate through the terms separated by '*'
        for (String mulExp : mulArray) {
            if (!mulExp.contains("n")) {
                result /= solveExpression(mulExp); // Divide the result by the expression value
            } else {
                newExp = mulExp; // Save the term containing 'n' for further processing
            }
        }

        // Check if 'n' is found after the '*' terms
        if (newExp.equals("n")) {
            return extracted(result); // Extract the result and return it
        }

        String[] divArray = newExp.split("/");

        // Handle cases when 'n' is in the numerator or denominator
        if (divArray[0].contains("n")) {
            result *= solveExpression(divArray[1]); // Multiply the result by the expression value
        } else {
            result = solveExpression(divArray[0]) / result; // Divide the expression value by the result
        }

        // Round off the result to 4 decimal points
        return extracted(result);
    }

    /**
     * Extract the result and round it off to 4 decimal points.
     *
     * @param result The result value to be extracted.
     * @return The result value rounded off to 4 decimal points.
     */
    private static double extracted(double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        return Double.parseDouble(decimalFormat.format(result));
    }

    /**
     * Parse and evaluate the given mathematical expression.
     *
     * @param mathExp The mathematical expression to be evaluated.
     * @return The evaluated result of the mathematical expression.
     */
    public static double solveExpression(final String mathExp) {
        return new Object() {
            int position = -1, chr;

            void nextChar() {
                chr = (++position < mathExp.length()) ? mathExp.charAt(position) : -1;
            }

            boolean consume(int charToConsume) {
                while (chr == ' ')
                    nextChar();
                if (chr == charToConsume) {
                    nextChar();
                    return true;
                }
                return false;
            }

            /**
             * Parse the mathematical expression and return the evaluated result.
             *
             * @return The evaluated result of the mathematical expression.
             */
            double parseMathExp() {
                nextChar();
                double x = parseNextTerm();
                if (position < mathExp.length())
                    throw new RuntimeException("Unexpected: " + (char) chr);
                return x;
            }

            double parseNextTerm() {
                double x = parseNextFactor();
                for (; ; ) {
                    if (consume('*'))
                        x *= parseNextFactor(); // multiplication
                    else if (consume('/'))
                        x /= parseNextFactor(); // division
                    else if (consume('-'))
                        x -= parseNextFactor(); // subtraction
                    else if (consume('+'))
                        x += parseNextFactor(); // addition
                    else
                        return x;
                }
            }

            double parseNextFactor() {
                double x;
                int startPos = this.position;
                if ((chr >= '0' && chr <= '9') || chr == '.') { // numbers
                    while ((chr >= '0' && chr <= '9') || chr == '.')
                        nextChar();
                    x = Double.parseDouble(mathExp.substring(startPos, this.position));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) chr);
                }
                return x;
            }
        }.parseMathExp();
    }

    public static void main(String[] args) {
        System.out.println(findValueOfN("4/n+20-10", 100)); // Expected Output : 0.0444
        System.out.println(findValueOfN("100*5-n", 100)); // Expected Output : 400.0
        System.out.println(findValueOfN("10*n+3-5", 10)); // expected Output : 1.2
        System.out.println(findValueOfN("15-n*5", 20)); // Expected output : -1.0
        System.out.println(findValueOfN("n+5*27", 9)); //Expected output : -126.0
        System.out.println(findValueOfN("100+n/4*50", 200));// Expected Output : 8.0
        System.out.println(findValueOfN("n*4+3/2", 5.5)); //Expected Output : 1.0
    }
}

