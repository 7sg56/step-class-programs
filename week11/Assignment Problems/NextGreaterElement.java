import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        System.out.println("Next Greater Elements:");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " -> " + result[i]);
    }
}
