/**
 * Created by campbell on 2015/12/18.
 */
public class Main {

    public Main(int ceiling) {
        for (int i = ceiling; i > 1; --i) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.print(i);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new Main(1000);
    }

    private boolean isPrime(int value) {
        for (int i = value - 1; i > 1; --i) {
            if ((value / (double) i) % 1 == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(int value) {
        String valueString = String.valueOf(value);
        int lastCharIndex = valueString.length() - 1;
        for (int i = 0; i < Math.round(valueString.length() / 2); i++) {
            if (valueString.charAt(i) != valueString.charAt(lastCharIndex - i)) {
                return false;
            }
        }
        return true;
    }
}
