import java.util.*;

class MyStack {
    private List<Integer> stack = new ArrayList<>();

    public void push(int item) {
        stack.add(item);
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.remove(stack.size() - 1);
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack: " + stack);
    }
}

public class StackDemo {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
        System.out.println("Popped: " + s.pop());
        System.out.println("Top: " + s.peek());
    }
}
