import java.util.Scanner;

public class main4 {

    // Encrypt text by shifting ASCII values with wrap-around for alphabets
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encrypted.append(shiftChar(ch, shift));
        }
        return encrypted.toString();
    }

    // Decrypt text by shifting ASCII values backward
    public static String decrypt(String text, int shift) {
        // Decrypting is just encrypting with negative shift
        return encrypt(text, -shift);
    }

    // Shift a single character with wrap-around for A-Z, a-z; leave others unchanged
    private static char shiftChar(char ch, int shift) {
        if (ch >= 'A' && ch <= 'Z') {
            // Uppercase wrap around
            int base = 'A';
            return (char) (base + (ch - base + shift + 26) % 26);
        } else if (ch >= 'a' && ch <= 'z') {
            // Lowercase wrap around
            int base = 'a';
            return (char) (base + (ch - base + shift + 26) % 26);
        } else {
            // Non-alphabetic chars unchanged
            return ch;
        }
    }

    // Display ASCII values of characters in a string
    public static void displayAsciiValues(String label, String text) {
        System.out.println(label + ":");
        System.out.print("Text : ");
        System.out.println(text);
        System.out.print("ASCII: ");
        for (char ch : text.toCharArray()) {
            System.out.print((int) ch + " ");
        }
        System.out.println("\n");
    }

    // Validate if decrypted text matches original
    public static boolean validateDecryption(String original, String decrypted) {
        return original.equals(decrypted);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String originalText = scanner.nextLine();

        System.out.print("Enter shift value (integer): ");
        int shift = scanner.nextInt();

        String encryptedText = encrypt(originalText, shift);
        String decryptedText = decrypt(encryptedText, shift);

        displayAsciiValues("Original Text", originalText);
        displayAsciiValues("Encrypted Text", encryptedText);
        displayAsciiValues("Decrypted Text", decryptedText);

        System.out.println("Decryption " + (validateDecryption(originalText, decryptedText) ? "successful!" : "failed!"));

        scanner.close();
    }
}
