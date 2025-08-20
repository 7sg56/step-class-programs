import java.util.Scanner;

public class main3 {

    static class Result {
        long timeTaken;
        int length;

        Result(long timeTaken, int length) {
            this.timeTaken = timeTaken;
            this.length = length;
        }
    }

    public static Result stringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s = s + "a";
        }
        long end = System.currentTimeMillis();
        return new Result(end - start, s.length());
    }

    public static Result stringBuilderAppend(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new Result(end - start, sb.length());
    }

    public static Result stringBufferAppend(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new Result(end - start, sb.length());
    }

    public static void displayResults(Result concat, Result builder, Result buffer) {
        System.out.println("\nPerformance Comparison:");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s | %-15s | %-15s\n", "Method", "Time (ms)", "Final Length");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s | %-15d | %-15d\n", "String Concatenation", concat.timeTaken, concat.length);
        System.out.printf("%-20s | %-15d | %-15d\n", "StringBuilder", builder.timeTaken, builder.length);
        System.out.printf("%-20s | %-15d | %-15d\n", "StringBuffer", buffer.timeTaken, buffer.length);
        System.out.println("---------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of iterations: ");
        int iterations = scanner.nextInt();

        Result concatResult = stringConcat(iterations);
        Result builderResult = stringBuilderAppend(iterations);
        Result bufferResult = stringBufferAppend(iterations);

        displayResults(concatResult, builderResult, bufferResult);

        scanner.close();
    }
}
