package lab1.test;

public class PokerTest implements RandomnessTestStrategy {
    @Override
    public boolean execute(String bitString) {
        int[] combinations = new int[16];
        for (int i = 0; i <= bitString.length() - 4; i += 4) {
            String substring = bitString.substring(i, i + 4);
            int combination = Integer.parseInt(substring, 2);
            combinations[combination]++;
        }
        double sumOfSquares = 0;
        for (int count : combinations) {
            sumOfSquares += Math.pow(count, 2);
        }
        double x = (16.0 / 5000.0) * sumOfSquares - 5000.0;
        return x > 2.16 && x < 46.17;
    }
}