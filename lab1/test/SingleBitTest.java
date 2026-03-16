package lab1.test;

public class SingleBitTest implements RandomnessTestStrategy {
    @Override
    public boolean execute(String bitString) {
        long ones = bitString.chars().filter(ch -> ch == '1').count();
        return ones > 9725 && ones < 10275;
    }
}