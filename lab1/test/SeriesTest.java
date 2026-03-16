package lab1.test;

public class SeriesTest implements RandomnessTestStrategy {
    @Override
    public boolean execute(String bitString) {
        if (bitString == null || bitString.isEmpty()) return false;

        int[] seriesCounts0 = new int[6];
        int[] seriesCounts1 = new int[6];
        int currentSeries = 1;

        for (int i = 1; i < bitString.length(); i++) {
            if (bitString.charAt(i) == bitString.charAt(i - 1)) {
                currentSeries++;
            } else {
                recordSeries(bitString.charAt(i - 1), currentSeries, seriesCounts0, seriesCounts1);
                currentSeries = 1;
            }
        }
        recordSeries(bitString.charAt(bitString.length() - 1), currentSeries, seriesCounts0, seriesCounts1);

        return seriesCountCompliance(seriesCounts0) && seriesCountCompliance(seriesCounts1);
    }

    private void recordSeries(char bit, int length, int[] counts0, int[] counts1) {
        int index = Math.min(length - 1, 5);
        if (bit == '0') {
            counts0[index]++;
        } else {
            counts1[index]++;
        }
    }

    private boolean seriesCountCompliance(int[] counts) {
        if (counts.length != 6) return false;
        return (counts[0] >= 2315 && counts[0] <= 2685) &&
                (counts[1] >= 1114 && counts[1] <= 1386) &&
                (counts[2] >= 527 && counts[2] <= 723) &&
                (counts[3] >= 240 && counts[3] <= 384) &&
                (counts[4] >= 103 && counts[4] <= 209) &&
                (counts[5] >= 103 && counts[5] <= 209);
    }
}