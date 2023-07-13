package Stack;

import java.util.Stack;

/**
 * Implementation of a stack with the ability to retrieve the minimum element efficiently.
 */
class MyMinStack {

    Stack<Integer> s;
    int min;

    /**
     * Constructs an instance of MyMinStack.
     */
    MyMinStack() {
        s = new Stack<>();
    }

    /**
     * Pushes an element onto the stack.
     * If the stack is empty, the element becomes the minimum.
     * If the element is less than or equal to the current minimum, it is pushed in a modified form,
     * and the minimum is updated accordingly.
     *
     * @param x The element to be pushed onto the stack.
     */
    void push(int x) {
        if (s.isEmpty()) {
            min = x;
            s.add(x);
        } else if (x <= min) {
            // If x is less than or equal to the current minimum,
            // we push 2*x - min onto the stack and update the minimum to x.
            // You can find explanation on why 2*min - t in https://docs.google.com/document/d/1hV2hOIytacEpe2eLJGpdiefBoBAHmFusLqzu-Goie3k/edit
            s.add(2 * x - min);
            min = x;
        } else {
            s.add(x);
        }
    }

    /**
     * Removes and returns the top element from the stack.
     * If the removed element was a modified value (2*x - min), the original minimum value is restored.
     *
     * @return The removed element from the stack.
     */
    int pop() {
        int t = s.peek();
        s.pop();
        if (t <= min) {
            int res = min;
            // If the removed element was a modified value,
            // we restore the original minimum value by calculating 2*min - t.
            // You can find explanation on why 2*min - t in https://docs.google.com/document/d/1hV2hOIytacEpe2eLJGpdiefBoBAHmFusLqzu-Goie3k/edit
            min = 2 * min - t;
            return res;
        } else {
            return t;
        }
    }

    /**
     * Retrieves the top element from the stack without removing it.
     * If the top element is a modified value (2*x - min), the original element is returned.
     *
     * @return The top element of the stack.
     */
    int peek() {
        int t = s.peek();
        return Math.max(t, min);
    }

    /**
     * Retrieves the minimum element from the stack.
     *
     * @return The minimum element in the stack.
     */
    int getMin() {
        return min;
    }
}

public class MinStackWithNoSpaceNegativesHandled {

    public static void main(String[] args) {
        MyMinStack s = new MyMinStack();
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        System.out.println("Minimum Element from Stack: " + s.getMin());
        System.out.println("Popped Element from stack is " + s.pop());
        System.out.println("Minimum Element from Stack: " + s.getMin());

        s = new MyMinStack();

        s.push(20);
        s.push(10);
        System.out.println("Minimum till now for the stack is " + s.getMin());
        s.push(5);
        System.out.println("Minimum till now for the stack is " + s.getMin());
        System.out.println("Popped Element from stack is " + s.pop());
        System.out.println("Minimum till now for the stack is " + s.getMin());
        System.out.println("Popped Element from stack is " + s.pop());
        System.out.println("Minimum till now for the stack is " + s.getMin());


    }
}

