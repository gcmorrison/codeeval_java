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
public class LettercaseRatioTest {

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
        doReturn(testOutput).when(classUnderTest).calculateRatios(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.calculateRatios(null));
        assertNull(classUnderTest.calculateRatios(""));
    }

    @Test
    public void testNoCase() throws Exception {
        assertEquals("lowercase: 0.00 uppercase: 0.00", classUnderTest.calculateRatios("!"));
    }

    @Test
    public void testLowercaseOnly() throws Exception {
        assertEquals("lowercase: 100.00 uppercase: 0.00", classUnderTest.calculateRatios("a"));
        assertEquals("lowercase: 100.00 uppercase: 0.00", classUnderTest.calculateRatios("abc"));
        assertEquals("lowercase: 100.00 uppercase: 0.00", classUnderTest.calculateRatios("kjhasdkjfhkasjhdf"));
    }

    @Test
    public void testUppercaseOnly() throws Exception {
        assertEquals("lowercase: 0.00 uppercase: 100.00", classUnderTest.calculateRatios("WR"));
        assertEquals("lowercase: 0.00 uppercase: 100.00", classUnderTest.calculateRatios("DFASDF"));
        assertEquals("lowercase: 0.00 uppercase: 100.00", classUnderTest.calculateRatios("JDFSKLJLKJSL"));
    }

    @Test
    public void testMixedCase() throws Exception {
        assertEquals("lowercase: 50.00 uppercase: 50.00", classUnderTest.calculateRatios("aBcDeF"));
        assertEquals("lowercase: 33.33 uppercase: 66.67", classUnderTest.calculateRatios("abcDEFGHI"));
        assertEquals("lowercase: 54.55 uppercase: 45.45", classUnderTest.calculateRatios("jHAKkjslfAH"));
    }
}
