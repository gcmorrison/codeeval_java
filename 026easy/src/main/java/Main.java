import java.io.File;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/08.
 */
public class Main {
    File fileToCheck;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.handleArgs(args);
    }

    public void handleArgs(String[] args) {
        parseArgs(args);
        printFileSize();
    }

    private void printFileSize() {
        System.out.print(fileToCheck.length());
    }

    private File getFile(String filename) {
        return new File(filename);
    }

    private void parseArgs(String[] args) {
        fileToCheck = getFile(args[0]);
    }
}
