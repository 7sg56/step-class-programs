
import java.util.Scanner;

public class main2 {

    static char toUpper(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char)(ch - 32);
        }
        return ch;
    }

    static char toLower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char)(ch + 32);
        }
        return ch;
    }

    static String convertToUpperCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(toUpper(text.charAt(i)));
        }
        return sb.toString();
    }

    static String convertToLowerCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(toLower(text.charAt(i)));
        }
        return sb.toString();
    }

    static String convertToTitleCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                sb.append(ch);
                newWord = true;
            } else {
                if (newWord) {
                    sb.append(toUpper(ch));
                    newWord = false;
                } else {
                    sb.append(toLower(ch));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String upper = convertToUpperCase(input);
        String lower = convertToLowerCase(input);
        String title = convertToTitleCase(input);

        System.out.println("\nCase Conversion Results:");
        System.out.println("----------------------------");
        System.out.printf("%-12s : %s\n", "Uppercase", upper);
        System.out.printf("%-12s : %s\n", "Lowercase", lower);
        System.out.printf("%-12s : %s\n", "Title Case", title);

        sc.close();
    }
}
