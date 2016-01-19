import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Campbell on 2016/01/15.
 */
public class SimpleSortingTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testOneNumber() throws Exception {
        classUnderTest.printResult("1");
        verify(mockOut).println(String.format("%.3f", 1f));
    }

    @Test
    public void testTwoSortedNumbers() throws Exception {
        classUnderTest.printResult("1 5.3");
        verify(mockOut).println(String.format("%.3f %.3f", 1f, 5.3));
    }

    @Test
    public void testThreeUnsortedNumbers() throws Exception {
        classUnderTest.printResult("4.1 3 3.9");
        verify(mockOut).println(String.format("%.3f %.3f %.3f", 3f, 3.9, 4.1));
    }
}
