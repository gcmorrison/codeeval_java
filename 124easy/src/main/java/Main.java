import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/25.
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
        System.out.println(calculateBestRoute(line));
    }

    public String calculateBestRoute(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String distances;

        int numberOfCities = countNumberOfCities(input);
        int[] distancesList = buildDistancesList(input, numberOfCities);
        distancesList = sort(distancesList, 0, numberOfCities - 1);

        distances = String.valueOf(distancesList[0]);
        for (int i = 1; i < numberOfCities; i++) {
            distances += "," + (distancesList[i] - distancesList[i - 1]);
        }

        return distances;
    }

    private int countNumberOfCities(String input) {
        int count = 0;

        for (char letter : input.toCharArray()) {
            if (letter == ';') {
                count++;
            }
        }

        return count;
    }

    private int[] buildDistancesList(String input, int numberOfCities) {
        int[] distances = new int[numberOfCities];

        String city;
        int index = 0, cityStart = 0, cityEnd = 0;
        while (cityEnd > -1 && index < numberOfCities) {
            cityEnd = input.indexOf(';', cityStart);

            if (cityEnd == -1) {
                city = input.substring(cityStart);
                distances[index] = Integer.valueOf(city.substring(city.indexOf(',') + 1));
            } else {
                city = input.substring(cityStart, cityEnd);
                distances[index] = Integer.valueOf(city.substring(city.indexOf(',') + 1));
            }

            cityStart = cityEnd + 1;
            index++;
        }

        return distances;
    }

    private int[] sort(int[] distancesList, int sortFrom, int sortTo) {

        if (sortFrom < sortTo) {
            int partition = partition(distancesList, sortFrom, sortTo);
            sort(distancesList, sortFrom, partition - 1);
            sort(distancesList, partition + 1, sortTo);
        }

        return distancesList;
    }

    private int partition(int[] distancesList, int sortFrom, int sortTo) {
        int pivot = distancesList[getPivotIndex(distancesList, sortFrom, sortTo)];
        int index = sortFrom;

        for (int i = sortFrom; i <= sortTo - 1; i++) {
            if (distancesList[i] <= pivot) {
                swap(distancesList, index, i);
                index++;
            }
        }

        swap(distancesList, index, sortTo);

        return index;
    }

    private int getPivotIndex(int[] distancesList, int sortFrom, int sortTo) {
        return sortTo;
    }

    private void swap(int[] distancesList, int source, int destination) {
        int temp = distancesList[source];
        distancesList[source] = distancesList[destination];
        distancesList[destination] = temp;
    }

}
