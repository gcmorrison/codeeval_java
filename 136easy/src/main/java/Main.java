import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/01.
 */
public class Main {
    private byte previousCarPosition = -1;
    private byte currentGatePos, currentCheckPos;

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
        System.out.println(handleRaceLine(line));
    }

    public String handleRaceLine(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        resetState();

        byte newCarPos = getNewCarPos(input);
        String raceLine = buildRaceLine(input, newCarPos, previousCarPosition);
        previousCarPosition = newCarPos;

        return raceLine;
    }

    private byte getNewCarPos(String input) {
        for (byte i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '_':
                    currentGatePos = i;
                    break;
                case 'C':
                    currentCheckPos = i;
                    break;
            }
        }

        return currentCheckPos >= 0 ? currentCheckPos : currentGatePos;
    }

    private String buildRaceLine(String input, byte newCarPos, byte previousCarPosition) {
        StringBuilder sb = new StringBuilder(input.length());

        sb.append(input.substring(0, newCarPos));

        if (previousCarPosition == -1 || newCarPos == previousCarPosition) {
            sb.append('|');
        } else if (newCarPos < previousCarPosition) {
            sb.append('/');
        } else {
            sb.append('\\');
        }

        sb.append(input.substring(newCarPos + 1));
        return sb.toString();
    }

    private void resetState() {
        currentGatePos = -1;
        currentCheckPos = -1;
    }
}
