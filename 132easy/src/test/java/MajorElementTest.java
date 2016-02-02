import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/01.
 */
public class MajorElementTest {

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
        doReturn(testOutput).when(classUnderTest).findMajorElement(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertEquals("None", classUnderTest.findMajorElement(null));
        assertEquals("None", classUnderTest.findMajorElement(""));
    }

    @Test
    public void testNoMajorElement_EvenLength() throws Exception {
        assertEquals("None", classUnderTest.findMajorElement("1,2,1,3,4,5"));
    }

    @Test
    public void testHasMajorElement_EvenLength() throws Exception {
        assertEquals("2", classUnderTest.findMajorElement("1,2,1,3,2,2"));
    }

    @Test
    public void testNoMajorElement_UnEvenLength() throws Exception {
        assertEquals("None", classUnderTest.findMajorElement("1,2,1,3,4"));
    }

    @Test
    public void testHasMajorElement_UnEvenLength() throws Exception {
        assertEquals("2", classUnderTest.findMajorElement("1,2,1,3,2,2,4"));
    }
}
