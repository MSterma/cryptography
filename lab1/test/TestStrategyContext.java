package lab1.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TestStrategyContext {

    private final Map<String, RandomnessTestStrategy> strategies;

    public TestStrategyContext() {
        strategies = new HashMap<>();
        strategies.put("single_bit", new SingleBitTest());
        strategies.put("longest_series", new LongestSeriesTest());
        strategies.put("poker", new PokerTest());
        strategies.put("series", new SeriesTest());
    }

    public boolean test(String filePath, String testName) {
        RandomnessTestStrategy strategy = strategies.get(testName.toLowerCase());

        if (strategy == null) {
            throw new IllegalArgumentException("wrong lab1.test selected");
        }

        String bitString;
        try {
            bitString = new String(Files.readAllBytes(Paths.get(filePath))).trim();
        } catch (IOException e) {
            System.err.println("file error "+ e.getMessage());
            return false;
        }

        return strategy.execute(bitString);
    }
}