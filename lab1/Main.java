package lab1;

import lab1.algorithms.BlumBlumShubGenerator;
import lab1.test.TestStrategyContext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String OUTPUT_FILE = "random.txt";
    private static final int BITS_TO_GENERATE = 20000;

    public static void main(String[] args) {
        long p = 21379;
        long q = 69427;

        try {
            BlumBlumShubGenerator generator = new BlumBlumShubGenerator(p, q);
            generateAndSaveBits(generator, BITS_TO_GENERATE, OUTPUT_FILE);
            System.out.println("Start generating");
            System.out.println("Finished  generating");
            TestStrategyContext tester = new TestStrategyContext();
            System.out.println("Start testing");
            System.out.println("Single Bit: " + tester.test(OUTPUT_FILE, "single_bit"));
            System.out.println("Poker: " + tester.test(OUTPUT_FILE, "poker"));
            System.out.println("Longest Series: " + tester.test(OUTPUT_FILE, "longest_series"));
            System.out.println("Series: " + tester.test(OUTPUT_FILE, "series"));
            System.out.println("Finished Testing");

        } catch (IllegalArgumentException | IOException e) {
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }
    private static void generateAndSaveBits(BlumBlumShubGenerator generator, int count, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < count; i++) {
                writer.write(String.valueOf(generator.nextBit()));
            }
        }
    }
}