import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main6 {

    // Manual split of text into words without using split()
    public static String[] splitIntoWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                if (start != i) { // avoid empty words from multiple spaces
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        return words.toArray(new String[0]);
    }

    // Left justify text using StringBuilder
    public static List<String> leftJustify(String[] words, int width) {
        List<String> lines = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineLength = words[index].length();
            int last = index + 1;

            // Find how many words fit on this line
            while (last < words.length) {
                if (lineLength + 1 + words[last].length() > width) break;
                lineLength += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int gaps = last - index - 1;

            // If last line or line with only one word, left-align by adding spaces at end
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(' ');
                }
                // pad remaining spaces at the end
                for (int i = sb.length(); i < width; i++) {
                    sb.append(' ');
                }
            } else {
                // Distribute spaces evenly
                int totalSpaces = width - lineLength + gaps; // because lineLength counts 1 space per gap
                int spaceBetween = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int s = 0; s <= spaceBetween; s++) { // +1 for the mandatory space
                            sb.append(' ');
                        }
                        if (extraSpaces > 0) {
                            sb.append(' ');
                            extraSpaces--;
                        }
                    }
                }
            }
            lines.add(sb.toString());
            index = last;
        }

        return lines;
    }

    // Center-align text using StringBuilder
    public static List<String> centerAlign(List<String> lines, int width) {
        List<String> centeredLines = new ArrayList<>();
        for (String line : lines) {
            int padding = width - line.trim().length();
            int padLeft = padding / 2;
            int padRight = padding - padLeft;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < padLeft; i++) sb.append(' ');
            sb.append(line.trim());
            for (int i = 0; i < padRight; i++) sb.append(' ');

            centeredLines.add(sb.toString());
        }
        return centeredLines;
    }

    // Left justify using String concatenation (for performance comparison)
    public static List<String> leftJustifyConcat(String[] words, int width) {
        List<String> lines = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineLength = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (lineLength + 1 + words[last].length() > width) break;
                lineLength += 1 + words[last].length();
                last++;
            }

            String line = "";
            int gaps = last - index - 1;

            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    line += words[i];
                    if (i != last - 1) line += " ";
                }
                while (line.length() < width) {
                    line += " ";
                }
            } else {
                int totalSpaces = width - lineLength + gaps;
                int spaceBetween = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int i = index; i < last; i++) {
                    line += words[i];
                    if (i < last - 1) {
                        for (int s = 0; s <= spaceBetween; s++) {
                            line += " ";
                        }
                        if (extraSpaces > 0) {
                            line += " ";
                            extraSpaces--;
                        }
                    }
                }
            }

            lines.add(line);
            index = last;
        }

        return lines;
    }

    // Display lines with line numbers and character count
    public static void displayLines(String title, List<String> lines) {
        System.out.println("\n" + title + ":");
        System.out.println("---------------------------------");
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("%2d | %s | (%d chars)\n", i + 1, lines.get(i), lines.get(i).length());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text to format:");
        String text = sc.nextLine();

        System.out.print("Enter desired line width: ");
        int width = sc.nextInt();

        String[] words = splitIntoWords(text);

        // Using StringBuilder
        long startSB = System.nanoTime();
        List<String> leftJustifiedSB = leftJustify(words, width);
        long endSB = System.nanoTime();

        List<String> centeredSB = centerAlign(leftJustifiedSB, width);

        // Using String concatenation
        long startStr = System.nanoTime();
        List<String> leftJustifiedStr = leftJustifyConcat(words, width);
        long endStr = System.nanoTime();

        // Display results
        System.out.println("\nOriginal Text:");
        System.out.println(text);

        displayLines("Left Justified (StringBuilder)", leftJustifiedSB);
        displayLines("Center Aligned (StringBuilder)", centeredSB);

        System.out.printf("\nPerformance Comparison:\n");
        System.out.printf("Left Justify with StringBuilder: %.3f ms\n", (endSB - startSB) / 1_000_000.0);
        System.out.printf("Left Justify with String Concatenation: %.3f ms\n", (endStr - startStr) / 1_000_000.0);

        sc.close();
    }
}
