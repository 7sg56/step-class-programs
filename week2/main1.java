import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main text: ");
        String text = sc.nextLine();

        System.out.print("Enter substring to find: ");
        String toFind = sc.nextLine();

        System.out.print("Enter substring to replace with: ");
        String toReplace = sc.nextLine();

        StringBuilder result = new StringBuilder();
        int i = 0;
        int subLen = toFind.length();

        while (i < text.length()) {
            if (i <= text.length() - subLen && text.substring(i, i + subLen).equals(toFind)) {
                result.append(toReplace);
                i += subLen;
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }

        System.out.println("\nText after manual replacement:");
        System.out.println(result.toString());

        sc.close();
    }
}
