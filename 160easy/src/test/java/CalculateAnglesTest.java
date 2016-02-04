import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/04.
 */
public class CalculateAnglesTest {

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
        doReturn(testOutput).when(classUnderTest).calculateAngle(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.calculateAngle(null));
        assertNull(classUnderTest.calculateAngle(""));
    }

    @Test
    public void testNoFractions() throws Exception {
        assertEquals("0.00'00\"", classUnderTest.calculateAngle("0"));
        assertEquals("1.00'00\"", classUnderTest.calculateAngle("1"));
        assertEquals("354.00'00\"", classUnderTest.calculateAngle("354"));
    }

    @Test
    public void testMinutes() throws Exception {
        assertEquals("0.01'00\"", classUnderTest.calculateAngle("0.0169"));
        assertEquals("0.20'00\"", classUnderTest.calculateAngle("0.3334"));
    }

    @Test
    public void testSeconds() throws Exception {
        assertEquals("0.00'01\"", classUnderTest.calculateAngle("0.000278"));
        assertEquals("0.00'20\"", classUnderTest.calculateAngle("0.00556"));
    }

    @Test
    public void testCombination() throws Exception {
        assertEquals("1.23'45\"", classUnderTest.calculateAngle("1.395834"));
    }
}
