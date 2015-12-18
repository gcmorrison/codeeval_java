/**
 * Created by campbell on 2015/12/18.
 */
public class Main {
    public static void main(String[] args) {
        System.out.print(new Main().calculateSumOfPrimes(1000));
    }

    public int calculateSumOfPrimes(int numberOfPrimes) {
        int foundPrimes = 1;
        int sumOfPrimes = 0;

        long i = 2;
        while (foundPrimes <= numberOfPrimes) {
            if (isPrime(i)) {
                sumOfPrimes += i;
                foundPrimes++;
            }
            i++;
        }

        return sumOfPrimes;
    }

    boolean isPrime(long value) {
        for (int i = 2; i < value; i++) {
            if ((value / (double) i) % 1 == 0) {
                return false;
            }
        }
        return true;
    }
}
