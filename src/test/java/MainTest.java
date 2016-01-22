/**
 * Created by campbell on 2016/01/08.
 */

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

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


    @Test
    public void testPrintResult() throws Exception {
        String testOutput = "testOutput";

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).doSomething(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.doSomething(null));
        assertNull(classUnderTest.doSomething(""));
    }
}
