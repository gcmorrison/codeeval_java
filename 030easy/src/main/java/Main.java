import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Campbell on 2016/01/10.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            main.printResult(line);
        }
    }

    void printResult(String line) {
        System.out.println(handleInput(line));
    }

    private String handleInput(String line) {
        if (line == null || line.trim().length() == 0) {
            return "";
        }

        String[] lists = line.split(";");
        if (lists.length < 2 || lists[0].length() == 0 || lists[1].length() == 0) {
            return "";
        }

        return findIntersection(lists[0].split(","), lists[1].split(","));
    }

    private String findIntersection(String[] list1, String[] list2) {
        int i = 0, j = 0;

        String intersection = "";
        int val1, val2;
        while (i < list1.length && j < list2.length) {
            val1 = Integer.parseInt(list1[i]);
            val2 = Integer.parseInt(list2[j]);
            if (val1 < val2) {
                i++;
            } else if (val1 > val2) {
                j++;
            } else {
                intersection += "," + list1[i];
                i++;
                j++;
            }
        }

        return intersection.replaceFirst("^,", "");
    }
}
