package Stack;

public class TwoStacksIn1Array {

    static int[] arr = new int[10];

    static int n = arr.length;
    static int top1 = -1, top2 = arr.length;
    static int size1 = 0, size2 = 0;

    public static void main(String[] args) {

        if (push1(10)) {
            System.out.println("Ele pushed into stack1");
        } else {
            System.out.println("Stack1 at capacity");
        }

        printStack1();
        printStack2();

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        printStack1();
        printStack2();

        int peek = peek1();
        System.out.println("Peek of stack 1 is " + peek);

        peek = peek2();
        System.out.println("Peek of stack 2 is " + peek);

        int data = pop1();
        System.out.println("Popped element of stack 1 is " + data);

        data = pop2();
        System.out.println("Popped element of stack 2 is " + data);

        printStack1();
        printStack2();

        int size = size1();
        System.out.println("Size of stack 1 is " + size);

        size = size2();
        System.out.println("Size of stack 2 is " + size);

        if (push1(20)) {
            System.out.println("Ele pushed into stack1");
        } else {
            System.out.println("Stack1 at capacity");
        }
        if (push1(19)) {
            System.out.println("Ele pushed into stack1");
        } else {
            System.out.println("Stack1 at capacity");
        }
        if (push1(16)) {
            System.out.println("Ele pushed into stack1");
        } else {
            System.out.println("Stack1 at capacity");
        }
        if (push1(12)) {
            System.out.println("Ele pushed into stack1");
        } else {
            System.out.println("Stack1 at capacity");
        }

        printStack1();
        printStack2();

        peek = peek1();
        System.out.println("Peek of stack 1 is " + peek);

        peek = peek2();
        System.out.println("Peek of stack 2 is " + peek);

        data = pop2();
        System.out.println("Popped element of stack 2 is " + data);

        printStack1();
        printStack2();

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        size = size1();
        System.out.println("Size of stack 1 is " + size);

        size = size2();
        System.out.println("Size of stack 2 is " + size);

        if (push2(100)) {
            System.out.println("Ele pushed into stack2");
        } else {
            System.out.println("Stack2 at capacity");
        }

        printStack1();
        printStack2();

        pop2();
        if (push1(190)) {
            System.out.println("Ele pushed into stack1");
        } else {
            System.out.println("Stack1 at capacity");
        }

        printStack1();
        printStack2();


    }

    private static void printStack1() {
        System.out.println("Stack 1 is");
        for (int i = top1; i >= 0; i--) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }

    private static void printStack2() {
        System.out.println("Stack 2 is");
        for (int i = n - 1; i >= top2; i--) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }

    public static int size1() {
        return top1 + 1;
    }

    public static int size2() {
        return n - top2;
    }

    public static int pop1() {
        if (top1 != -1) {
            int data = arr[top1];
            top1--;
            size1--;
            return data;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static int pop2() {
        if (top2 != n) {
            int data = arr[top2];
            top2++;
            size2--;
            return data;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static int peek1() {
        if (top1 != -1) {
            return arr[top1];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static int peek2() {
        if (top2 != n) {
            return arr[top2];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private static boolean push2(int data) {
        if (top2 - 1 != top1) {
            top2--;
            size2++;
            arr[top2] = data;
            return true;
        } else {
            return false;
        }
    }

    public static boolean push1(int data) {
        if (top1 + 1 != top2) {
            top1++;
            size1++;
            arr[top1] = data;
            return true;
        } else {
            return false;
        }
    }
}
