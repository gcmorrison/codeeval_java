import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Campbell on 2016/01/15.
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
        StringBuilder sb = new StringBuilder();

        for (double number : sortListOrNumbers(line)) {
            sb.append(String.format("%.3f ", number));
        }

        System.out.println(sb.toString().trim());
    }

    private double[] sortListOrNumbers(String line) {
        String[] numbersAsStrings = line.split(" ");
        double[] numbers = new double[numbersAsStrings.length];

        for (int i = 0; i < numbersAsStrings.length; i++) {
            numbers[i] = Double.parseDouble(numbersAsStrings[i]);
        }

        quickSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    private void quickSort(double[] numbers, int lowerBound, int upperBound) {
        int index = partition(numbers, lowerBound, upperBound);

        if (index > lowerBound) {
            quickSort(numbers, lowerBound, index - 1);
        }
        if (index < upperBound) {
            quickSort(numbers, index + 1, upperBound);
        }
    }

    private int partition(double[] numbers, int lowerBound, int upperBound) {
        double pivot = numbers[upperBound];
        int index = lowerBound;

        double temp = 0;
        for (int j = lowerBound; j < upperBound; j++) {
            if (numbers[j] <= pivot) {
                swapNumbers(numbers, index, j, temp);
                index++;
            }
        }

        swapNumbers(numbers, index, upperBound, temp);
        return index;
    }

    private void swapNumbers(double[] numbers, int firstIndex, int secondIndex, double temp) {
        temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }
}
