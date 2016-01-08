import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by campbell on 2016/01/08.
 */
public class FileSizeTest {
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
    public void testCreatesFileFromReceivesParameters() throws Exception {
        String testFilename = UUID.randomUUID().toString();

        classUnderTest.handleArgs(new String[]{testFilename});

        assertNotNull(classUnderTest.fileToCheck);
        assertEquals(testFilename, classUnderTest.fileToCheck.getName());
    }

    @Test
    public void testPrintResult_NoFile() throws Exception {
        classUnderTest.handleArgs(new String[]{UUID.randomUUID().toString()});

        assertFalse(classUnderTest.fileToCheck.exists());
        verify(mockOut).print(0l);
    }

    @Test
    public void testPrintResult_EmptyFile() throws Exception {
        classUnderTest.handleArgs(new String[]{testFilePaths + emptyFileName});

        assertTrue(classUnderTest.fileToCheck.exists());
        verify(mockOut).print(0l);
    }

    @Test
    public void testPrintResult_SampleFile() throws Exception {
        long expectedFileSize = 52;

        classUnderTest.handleArgs(new String[]{testFilePaths + sampleFileName});

        assertTrue(classUnderTest.fileToCheck.exists());
        verify(mockOut).print(expectedFileSize);
    }
}
