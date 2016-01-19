import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by Campbell on 2016/01/15.
 */
public class FindWriterTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testOneCharacterOneKey() throws Exception {
        classUnderTest.printResult("h| 1");

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('h');
        order.verify(mockOut).println();
    }

    @Test
    public void testOneWord() throws Exception {
        classUnderTest.printResult("lkjaoeiuh| 9 6 1 1 5");

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('h');
        order.verify(mockOut).print('e');
        order.verify(mockOut, times(2)).print('l');
        order.verify(mockOut).print('o');
        order.verify(mockOut).println();
    }
}
