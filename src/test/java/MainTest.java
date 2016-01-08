/**
 * Created by campbell on 2016/01/08.
 */

import org.junit.Before;

import java.io.File;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;

/**
 * This class is the template that all unit tests should be based off of
 */
public class MainTest {
    private static final String testFilePaths = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    private static final String emptyFileName = "emptyFile.txt";
    private static final String sampleFileName = "sampleFile.txt";

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }
}
