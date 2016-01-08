import java.io.IOException;

/**
 * Created by campbell on 2016/01/08.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().printOddNumbers(99);
    }

    public void printOddNumbers(int max) {
        for (int i = 0; i <= max; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
