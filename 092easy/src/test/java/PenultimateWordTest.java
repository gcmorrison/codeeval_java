import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Campbell on 2016/01/15.
 */
public class PenultimateWordTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testTwoWords() throws Exception {
        classUnderTest.printResult("one word");
        verify(mockOut).println("one");
    }

    @Test
    public void testManyWords() throws Exception {
        classUnderTest.printResult("this is my totally legitimate test");
        verify(mockOut).println("legitimate");
    }
}
