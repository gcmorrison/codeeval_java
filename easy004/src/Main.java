/**
 * Created by campbell on 2015/12/18.
 */
public class Main {
    public Main(int numberOfPrimes) {
        int foundPrimes = 1;
        long sumOfPrimes = 0;

        long i = 2;
        while (foundPrimes <= numberOfPrimes) {
            if (isPrime(i)) {
                sumOfPrimes += i;
                foundPrimes++;
            }
            i++;
        }
        System.out.print(sumOfPrimes);
    }

    public static void main(String[] args) {
        new Main(1000);
    }

    private boolean isPrime(long value) {
        for (int i = 2; i < value; i++) {
            if ((value / (double) i) % 1 == 0) {
                return false;
            }
        }
        return true;
    }
}
