package Stack;

public class StackOperationsLinkedList {
    public static void main(String[] args) {
        MyStackLL<String> myStack = new MyStackLL<>();

        myStack.push("Kanmani");
        myStack.push("OK Dhim dhim dhinna");

        myStack.printStack();

        String popped = myStack.pop();
        System.out.println("Popped Node is " + popped);

        popped = myStack.pop();
        System.out.println("Popped element is " + popped);

        boolean isEmpty = myStack.isEmpty();
        System.out.println("Is Stack Empty " + isEmpty);

        String peek = myStack.peek();
        System.out.println("Peek element is " + peek);

        myStack.push("Ok Bangaram");

        int size = myStack.getSize();
        System.out.println("Size of Stack is " + size);

        peek = myStack.peek();
        System.out.println("Peek element is " + peek);

        myStack.printStack();

    }
}
