import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/04.
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
        System.out.println(calculateAgeDistribution(line));
    }

    public String calculateAgeDistribution(String input) {
        if (input == null || input.length() == 0) {
            return "This program is for humans";
        }

        int age = getAge(input);

        return getAgeDescription(age);
    }

    private int getAge(String input) {
        int age;

        try {
            age = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            // NaN
            age = -1;
        }

        if (age < 0 || age > 100) {
            // Aaaaaaaliens
            age = -1;
        }

        return age;
    }

    private String getAgeDescription(int age) {
        switch (age) {
            case -1:
                return "This program is for humans";
            case 0:
            case 1:
            case 2:
                return "Still in Mama's arms";
            case 3:
            case 4:
                return "Preschool Maniac";
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return "Elementary school";
            case 12:
            case 13:
            case 14:
                return "Middle school";
            case 15:
            case 16:
            case 17:
            case 18:
                return "High school";
            case 19:
            case 20:
            case 21:
            case 22:
                return "College";
            default:
                return age < 66 ? "Working for the man" : "The Golden Years";
        }
    }
}
