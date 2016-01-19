import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * Created by Campbell on 2016/01/15.
 */
public class CapitalizeWordsTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testAlreadyCapitalized() throws Exception {
        String line = "This Statement Is False";
        classUnderTest.printResult(line);

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('T');
        order.verify(mockOut).print('h');
        order.verify(mockOut).print('i');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('S');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print('a');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('m');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('n');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('I');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('F');
        order.verify(mockOut).print('a');
        order.verify(mockOut).print('l');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print('e');
        order.verify(mockOut).println();
    }

    @Test
    public void testWordsStartWithNonCharacters() throws Exception {
        String line = "This 5tatement !s False";
        classUnderTest.printResult(line);

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('T');
        order.verify(mockOut).print('h');
        order.verify(mockOut).print('i');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('5');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print('a');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('m');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('n');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('!');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('F');
        order.verify(mockOut).print('a');
        order.verify(mockOut).print('l');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print('e');
        order.verify(mockOut).println();
    }

    @Test
    public void testLowercaseWords() throws Exception {
        String line = "this statement is false";
        classUnderTest.printResult(line);

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('T');
        order.verify(mockOut).print('h');
        order.verify(mockOut).print('i');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('S');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print('a');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('m');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('n');
        order.verify(mockOut).print('t');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('I');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('F');
        order.verify(mockOut).print('a');
        order.verify(mockOut).print('l');
        order.verify(mockOut).print('s');
        order.verify(mockOut).print('e');
        order.verify(mockOut).println();
    }
}
