import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/11.
 */
public class SelfDescribingNumberTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testPrintResult_NumberIsSelfDescribing() throws Exception {
        classUnderTest = spy(classUnderTest);
        doReturn(true).when(classUnderTest).isSelfDescribingNumber(any(String.class));
        classUnderTest.printResult(null);
        verify(mockOut).println(1);
    }

    @Test
    public void testPrintResult_NumberIsNotSelfDescribing() throws Exception {
        classUnderTest = spy(classUnderTest);
        doReturn(false).when(classUnderTest).isSelfDescribingNumber(any(String.class));
        classUnderTest.printResult(null);
        verify(mockOut).println(0);
    }

    @Test
    public void testBuildDescribingArray_OneDigit() throws Exception {
        assertArrayEquals(new short[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, classUnderTest.buildDescribingArray(new char[]{'0'}));
        assertArrayEquals(new short[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, classUnderTest.buildDescribingArray(new char[]{'1'}));
        assertArrayEquals(new short[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, classUnderTest.buildDescribingArray(new char[]{'2'}));
    }

    @Test
    public void testBuildDescribingArray_ManyDigits() throws Exception {
        assertArrayEquals(new short[]{0, 1, 0, 1, 1, 0, 0, 0, 0, 0}, classUnderTest.buildDescribingArray(new char[]{'3', '1', '4'}));
        assertArrayEquals(new short[]{1, 0, 0, 0, 1, 0, 2, 0, 0, 0}, classUnderTest.buildDescribingArray(new char[]{'6', '4', '6', '0'}));
        assertArrayEquals(new short[]{0, 0, 0, 0, 3, 3, 3, 0, 0, 0}, classUnderTest.buildDescribingArray(new char[]{'5', '6', '4', '6', '4', '5', '4', '6', '5'}));
        assertArrayEquals(new short[]{0, 11, 0, 0, 0, 0, 0, 0, 0, 0}, classUnderTest.buildDescribingArray(new char[]{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}));
    }

    @Test
    public void testIsSelfDescribingNumber() throws Exception {
        assertTrue(classUnderTest.isSelfDescribingNumber("2020"));
        assertFalse(classUnderTest.isSelfDescribingNumber("222"));
        assertTrue(classUnderTest.isSelfDescribingNumber("1210"));
        assertFalse(classUnderTest.isSelfDescribingNumber("92636"));
    }
}
