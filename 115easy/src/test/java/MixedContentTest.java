import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/22.
 */
public class MixedContentTest {

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
        doReturn(testOutput).when(classUnderTest).separateContent(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.separateContent(null));
        assertNull(classUnderTest.separateContent(""));
    }

    @Test
    public void testOneNumber() throws Exception {
        String testOutput = "15";
        assertEquals(testOutput, classUnderTest.separateContent(testOutput));
    }

    @Test
    public void testOneWord() throws Exception {
        String testOutput = "word";
        assertEquals(testOutput, classUnderTest.separateContent(testOutput));
    }

    @Test
    public void testOneWordOneNumber_NoSeparation() throws Exception {
        assertEquals("eiffel|65", classUnderTest.separateContent("eiffel,65"));
    }

    @Test
    public void testOneWordOneNumber_WithSeparation() throws Exception {
        assertEquals("gun|21", classUnderTest.separateContent("21,gun"));
    }

    @Test
    public void testMixedContent() throws Exception {
        assertEquals("i,am,legend|1,31,9001", classUnderTest.separateContent("1,i,31,am,9001,legend"));
    }

    @Test
    public void testMultipleMixedContent() throws Exception {
        assertEquals("sf,hhfgd,jk|45,8,234", classUnderTest.separateContent("45,sf,8,hhfgd,234,jk"));
        assertEquals("zxvc,tewr,a|5476,78,1", classUnderTest.separateContent("zxvc,5476,tewr,78,a,1"));
    }
}
