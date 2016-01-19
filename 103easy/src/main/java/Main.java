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
        System.out.println(findPlayerWithLowestUnique(line));
    }

    public int findPlayerWithLowestUnique(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        String[] playerPicks = getPlayerPicks(input);
        if (playerPicks.length == 0) {
            return 0;
        }

        byte[] pickCounts = new byte[9];
        for (String pick : playerPicks) {
            pickCounts[pick.charAt(0) - '1']++;
        }

        byte lowestUniqueIndex = findLowestUniquePickIndex(pickCounts);
        if (lowestUniqueIndex == -1) {
            return 0;
        }

        return findWhoPickedLowest(playerPicks, lowestUniqueIndex);
    }

    private String[] getPlayerPicks(String input) {
        return input.split(" ");
    }

    private byte findLowestUniquePickIndex(byte[] pickCounts) {
        for (byte i = 0; i < pickCounts.length; i++) {
            if (pickCounts[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    private int findWhoPickedLowest(String[] playerPicks, byte lowestUnique) {
        for (int i = 0; i < playerPicks.length; i++) {
            if (playerPicks[i].charAt(0) - '1' == lowestUnique) {
                return i + 1;
            }
        }

        return 0;
    }
}
