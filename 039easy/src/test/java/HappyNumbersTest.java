import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by campbell on 2016/01/11.
 */
public class HappyNumbersTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testIsHappyNumber_NoCalc() throws Exception {
        assertFalse(classUnderTest.isHappyNumber("0"));
        assertTrue(classUnderTest.isHappyNumber("1"));
    }

    @Test
    public void testIsHappyNumber_SmallAndHappy() throws Exception {
        assertTrue(classUnderTest.isHappyNumber("7"));
        assertTrue(classUnderTest.isHappyNumber("10"));
    }

    @Test
    public void testIsHappyNumber_SmallAndUnhappy() throws Exception {
        assertFalse(classUnderTest.isHappyNumber("4"));
        assertFalse(classUnderTest.isHappyNumber("3"));
    }

    @Test
    public void testPrintResult() throws Exception {
        classUnderTest.printResult("97");
        verify(mockOut).println("1");

        classUnderTest.printResult("123");
        verify(mockOut).println("0");
    }
}
