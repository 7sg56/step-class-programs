import java.util.*;

public class ReverseString {
    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray())
            stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty())
            reversed.append(stack.pop());
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "HELLO";
        System.out.println("Reversed: " + reverse(input));
    }
}
