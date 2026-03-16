package lab1.test;

public class LongestSeriesTest implements RandomnessTestStrategy {
    @Override
    public boolean execute(String bitString) {
        if (bitString == null || bitString.isEmpty()) return false;

        int longestSeries = 0;
        int currentSeries = 1;

        for (int i = 1; i < bitString.length(); i++) {
            if (bitString.charAt(i) == bitString.charAt(i - 1)) {
                currentSeries++;
            } else {
                if (currentSeries > longestSeries) {
                    longestSeries = currentSeries;
                }
                currentSeries = 1;
            }
        }
        if (currentSeries > longestSeries) {
            longestSeries = currentSeries;
        }

        return longestSeries < 26;
    }
}