package Stack;

public class StackOperations {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        int size = stack.size();
        System.out.println("Initial Size of Stack is " + size);

        Integer pop = stack.pop();
        if (pop == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Popped element is " + pop);
        }

        stack.push(100);
        System.out.println("Size of Stack after pushing 100 is " + stack.size());

        stack.printStack();

        stack.push(200);
        System.out.println("Size of Stack after pushing 200 is " + stack.size());

        boolean isEmpty = stack.isEmpty();
        System.out.println("Is Stack Empty " + isEmpty);

        Integer peek = stack.peek();
        if (peek == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Peek is " + peek);
        }

        stack.printStack();

        pop = stack.pop();
        if (pop == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Popped element is " + pop);
        }

        pop = stack.pop();
        if (pop == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Popped element is " + pop);
        }

        peek = stack.peek();
        if (peek == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Peek is " + peek);
        }

    }
}
