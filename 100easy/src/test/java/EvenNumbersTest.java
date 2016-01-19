import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/19.
 */
public class EvenNumbersTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testPrintResult_UnevenNumber() throws Exception {
        classUnderTest = spy(classUnderTest);
        doReturn(false).when(classUnderTest).isNumberEven(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(0);
    }

    @Test
    public void testPrintResult_EvenNumber() throws Exception {
        classUnderTest = spy(classUnderTest);
        doReturn(true).when(classUnderTest).isNumberEven(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(1);
    }

    @Test
    public void testTwoIsEvenNumber() throws Exception {
        assertTrue(classUnderTest.isNumberEven("2"));
    }

    @Test
    public void testZeroIsEvenNumber() throws Exception {
        assertTrue(classUnderTest.isNumberEven("0"));
    }

    @Test
    public void testFiveIsUnevenNumber() throws Exception {
        assertFalse(classUnderTest.isNumberEven("5"));
    }

    @Test
    public void testLargeEvenNumber() throws Exception {
        assertTrue(classUnderTest.isNumberEven("546478"));
    }

    @Test
    public void testLargeUnevenNumber() throws Exception {
        assertFalse(classUnderTest.isNumberEven("68841"));
    }
}
