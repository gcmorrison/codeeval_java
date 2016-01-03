import java.io.IOException;

/**
 * Created by Campbell on 2016/01/03.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();

        System.out.print(main.printResult());
    }

    String printResult() {
        String output = "";
        for (int i = 1; i <= 12; i++) {
            output = output + printLineFor(i, 12).trim() + "\n";
        }
        return output;
    }

    String printLineFor(int number, int range) {
        String line = "";
        String partial;
        int answer;
        for (int i = 1; i <= range; i++) {
            partial = " ";
            answer = i * number;
            if (answer < 100) {
                partial = " " + partial;
            }
            if (answer < 10) {
                partial = " " + partial;
            }
            line = line + partial + answer;
        }
        return line;
    }
}
