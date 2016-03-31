import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/05.
 */
public class Main {

    private String[] lineList;
    private int filledCount;

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;

        if ((line = buffer.readLine()) != null) {
            if (main.init(line)) {
                while ((line = buffer.readLine()) != null) {
                    line = line.trim();

                    main.handleLine(line);
                }
            }
        }

        main.printResult();
    }

    boolean init(String line) {
        try {
            lineList = new String[Integer.valueOf(line)];
            filledCount = 0;
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    void handleLine(String line) {
        if (filledCount < lineList.length) {
            fillUnoccupiedSpace(line);
        } else {
            addIfLonger(line);
        }
    }

    private void fillUnoccupiedSpace(String line) {
        // Find the first unoccupied space and fill it
        for (int i = 0; i < lineList.length; i++) {
            if (lineList[i] == null) {
                lineList[i] = line;
                filledCount++;
                return;
            }
        }
    }

    private void addIfLonger(String line) {
        int shortest = Integer.MAX_VALUE;
        int shortIndex = -1;

        // Find the shortest entry that LINE is longer than
        for (int i = 0; i < lineList.length; i++) {
            if (line.length() > lineList[i].length() && lineList[i].length() < shortest) {
                shortest = lineList[i].length();
                shortIndex = i;
            }
        }

        if (shortIndex > -1) {
            lineList[shortIndex] = line;
        }
    }

    void printResult() {
        if (lineList != null) {
            sortByLength(lineList, 0, lineList.length - 1);

            for (String line : lineList) {
                System.out.println(line);
            }
        }
    }

    private void sortByLength(String[] list, int lower, int upper) {
        if (lower < upper) {
            int partition = partition(list, lower, upper);
            sortByLength(list, lower, partition - 1);
            sortByLength(list, partition + 1, upper);
        }
    }

    private int partition(String[] list, int lower, int upper) {
        int pivot = list[upper].length();
        int index = lower;

        for (int i = lower; i < upper; i++) {
            if (list[i].length() >= pivot) {
                swap(list, index, i);
                index++;
            }
        }

        swap(list, index, upper);

        return index;
    }

    private void swap(String[] list, int source, int dest) {
        String temp = list[source];
        list[source] = list[dest];
        list[dest] = temp;
    }
}
