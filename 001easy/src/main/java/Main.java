import java.io.*;

/**
 * Created by Campbell on 2015/12/17.
 */
public class Main {
    File inputFile;

    public Main(String[] args) {
        inputFile = new File(args[0]);
    }

    public static void main(String[] args) {
        new Main(args).solve();
    }

    void solve() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(solveInput(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String solveInput(String input) {
        int[] params = parseLine(input);
        int fizz = params[0], buzz = params[1], range = params[2];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= range; i++) {
            sb.append(" ");
            if (i % fizz != 0 && i % buzz != 0) {
                sb.append(i);
                continue;
            }
            if (i % fizz == 0) {
                sb.append("F");
            }
            if (i % buzz == 0) {
                sb.append("B");
            }
        }

        return sb.toString().trim();
    }

    int[] parseLine(String input) {
        int[] params = new int[3];
        String[] elements = input.split(" ");

        for (int i = 0; i < elements.length; i++) {
            params[i] = Integer.valueOf(elements[i]);
        }

        return params;
    }
}
