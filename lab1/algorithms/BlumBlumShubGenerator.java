package lab1.algorithms;

import java.security.SecureRandom;
public class BlumBlumShubGenerator {

    private final long n;
    private long nextNum;

    public BlumBlumShubGenerator(long p, long q) {
        validateBlumPrime(p);
        validateBlumPrime(q);

        this.n = p * q;
        this.nextNum = init();
    }
    private void validateBlumPrime(long prime ) {
        if (prime % 4 != 3 || !isPrime(prime)) {
            throw new IllegalArgumentException(
                    "Not prime"
            );
        }
    }
    private boolean isPrime(long number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (long i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long init() {
        SecureRandom secureRandom = new SecureRandom();
        long seed;

        do {
            seed = Math.abs(secureRandom.nextLong() % this.n);
            if (seed < 0) seed = 1;
        } while (seed == 0 || gcd(this.n, seed) != 1);
        System.out.println(seed);
        return (seed * seed) % this.n;
    }

    public int nextBit() {
        int bit = (int) (this.nextNum % 2);
        this.nextNum = (this.nextNum * this.nextNum) % this.n;
        return bit;
    }
}