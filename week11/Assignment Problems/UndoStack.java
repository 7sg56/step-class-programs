import java.util.*;

public class UndoStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String text = "";

        while (true) {
            System.out.println("1. Type  2. Undo  3. Display  4. Exit");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter text: ");
                    String newText = sc.nextLine();
                    stack.push(text);
                    text += newText;
                }
                case 2 -> {
                    if (!stack.isEmpty()) text = stack.pop();
                    else System.out.println("Nothing to undo!");
                }
                case 3 -> System.out.println("Current Text: " + text);
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid!");
            }
        }
    }
}
