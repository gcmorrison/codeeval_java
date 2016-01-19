import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * Created by Campbell on 2016/01/15.
 */
public class SwapCaseTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testNoAlphabeticalCharacters() throws Exception {
        classUnderTest.printResult("12 3");

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('1');
        order.verify(mockOut).print('2');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('3');
        order.verify(mockOut).println();
    }

    @Test
    public void testAllLowercase() throws Exception {
        classUnderTest.printResult("a b c");

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('A');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('B');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('C');
        order.verify(mockOut).println();
    }

    @Test
    public void testAllUppercase() throws Exception {
        classUnderTest.printResult("DE!F");

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('d');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('!');
        order.verify(mockOut).print('f');
        order.verify(mockOut).println();
    }

    @Test
    public void testMixedCase() throws Exception {
        classUnderTest.printResult("hElLo WoRlD");

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).print('H');
        order.verify(mockOut).print('e');
        order.verify(mockOut).print('L');
        order.verify(mockOut).print('l');
        order.verify(mockOut).print('O');
        order.verify(mockOut).print(' ');
        order.verify(mockOut).print('w');
        order.verify(mockOut).print('O');
        order.verify(mockOut).print('r');
        order.verify(mockOut).print('L');
        order.verify(mockOut).print('d');
        order.verify(mockOut).println();
    }
}
