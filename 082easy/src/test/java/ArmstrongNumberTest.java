import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/14.
 */
public class ArmstrongNumberTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testIsArmstrongNumber_SingleDigit() throws Exception {
        assertTrue(classUnderTest.isArmstrongNumber("1"));
        assertTrue(classUnderTest.isArmstrongNumber("8"));
    }

    @Test
    public void testIsArmstrongNumber_MultipleDigits() throws Exception {
        assertFalse(classUnderTest.isArmstrongNumber("12"));
        assertTrue(classUnderTest.isArmstrongNumber("153"));
        assertFalse(classUnderTest.isArmstrongNumber("351"));
        assertTrue(classUnderTest.isArmstrongNumber("370"));
        assertTrue(classUnderTest.isArmstrongNumber("371"));
        assertTrue(classUnderTest.isArmstrongNumber("407"));
    }

    @Test
    public void testPrintResult() throws Exception {
        classUnderTest = spy(classUnderTest);

        doReturn(false).when(classUnderTest).isArmstrongNumber(anyString());
        classUnderTest.printResult(UUID.randomUUID().toString());
        verify(mockOut).println("False");

        reset(mockOut);

        doReturn(true).when(classUnderTest).isArmstrongNumber(anyString());
        classUnderTest.printResult(UUID.randomUUID().toString());
        verify(mockOut).println("True");
    }
}
