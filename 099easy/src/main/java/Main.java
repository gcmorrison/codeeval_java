import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/19.
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
        System.out.println(calculateDistance(line));
    }

    public int calculateDistance(String input) {
        String[] params = separateCoordinateDefinitions(input);
        String[] point1Coordinates = getCoordinatesForPointString(params[0]);
        String[] point2Coordinates = getCoordinatesForPointString(params[1]);

        return (int) applyDistanceAlgorithm(point1Coordinates, point2Coordinates);
    }

    private double applyDistanceAlgorithm(String[] point1Coordinates, String[] point2Coordinates) {
        return Math.sqrt(Math.pow(getAxisDifference(point1Coordinates[0], point2Coordinates[0]), 2) +
                Math.pow(getAxisDifference(point1Coordinates[1], point2Coordinates[1]), 2));
    }

    private int getAxisDifference(String point1Coordinate, String point2Coordinate) {
        return Integer.valueOf(point2Coordinate) - Integer.valueOf(point1Coordinate);
    }

    private String[] separateCoordinateDefinitions(String input) {
        return input.split("\\)[ ]*\\(");
    }

    private String[] getCoordinatesForPointString(String pointString) {
        return pointString.replaceAll("[\\(\\) ]*", "").split(",");
    }
}
