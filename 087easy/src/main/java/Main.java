import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Campbell on 2016/01/15.
 */
public class Main {

    private static final int BOARD_DIMENS = 256;

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;

        byte[][] board = new byte[BOARD_DIMENS][BOARD_DIMENS];
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            main.handleOperation(board, line);
        }
    }

    void handleOperation(byte[][] board, String line) {
        String[] params = parseParams(line);
        if (isValidOperation(params)) {
            if (isQueryCommand(params[0])) {
                if (isRowCommand(params[0])) {
                    System.out.println(handleQueryRow(board, Integer.parseInt(params[1])));
                } else if (isColumnCommand(params[0])) {
                    System.out.println(handleQueryColumn(board, Integer.parseInt(params[1])));
                }
            } else if (isSetCommand(params[0])) {
                if (isRowCommand(params[0])) {
                    handleSetRow(board, Integer.parseInt(params[1]), Byte.parseByte(params[2]));
                } else if (isColumnCommand(params[0])) {
                    handleSetColumn(board, Integer.parseInt(params[1]), Byte.parseByte(params[2]));
                }
            }
        }
    }

    String[] parseParams(String line) {
        return line.split(" ");
    }

    boolean isValidOperation(String[] params) {
        return (params.length == 2 && (params[0].equals("QueryRow") || params[0].equals("QueryCol"))) ||
                (params.length == 3 && (params[0].equals("SetRow") || params[0].equals("SetCol")));
    }

    boolean isSetCommand(String command) {
        return command.startsWith("Set");
    }

    boolean isQueryCommand(String command) {
        return command.startsWith("Query");
    }

    boolean isRowCommand(String command) {
        return command.endsWith("Row");
    }

    boolean isColumnCommand(String command) {
        return command.endsWith("Col");
    }

    byte[][] handleSetRow(byte[][] inputBoard, int rowIndex, byte setValue) {
        for (int i = 0; i < inputBoard.length; i++) {
            inputBoard[i][rowIndex] = setValue;
        }

        return inputBoard;
    }

    byte[][] handleSetColumn(byte[][] inputBoard, int colIndex, byte setValue) {
        for (int i = 0; i < inputBoard.length; i++) {
            inputBoard[colIndex][i] = setValue;
        }

        return inputBoard;
    }

    int handleQueryRow(byte[][] inputBoard, int rowIndex) {
        int query = 0;

        for (int i = 0; i < inputBoard.length; i++) {
            query += inputBoard[i][rowIndex];
        }

        return query;
    }

    int handleQueryColumn(byte[][] inputBoard, int colIndex) {
        int query = 0;

        for (int i = 0; i < inputBoard.length; i++) {
            query += inputBoard[colIndex][i];
        }

        return query;
    }
}
