import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/05.
 */
public class LongestLinesTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }
//
//    @Test
//    public void testPrintResult() throws Exception {
//        String testOutput = "testOutput";
//
//        classUnderTest = spy(classUnderTest);
//        doReturn(testOutput).when(classUnderTest).doSomething(anyString());
//
//        classUnderTest.printResult("");
//        verify(mockOut).println(testOutput);
//    }

    @Test
    public void testEmptyInput() throws Exception {
        classUnderTest.init(null);
        classUnderTest.printResult();
        verifyZeroInteractions(mockOut);

        classUnderTest.init("");
        classUnderTest.printResult();
        verifyZeroInteractions(mockOut);
    }

    @Test
    public void testOutputOneFromOne() throws Exception {
        String testInput = "testLine";

        classUnderTest.init("1");
        classUnderTest.handleLine(testInput);
        classUnderTest.printResult();

        verify(mockOut).println(testInput);
    }

    @Test
    public void testOutputOneFromTwo() throws Exception {
        String testInput = "longest Test Line";

        classUnderTest.init("1");
        classUnderTest.handleLine("ab");
        classUnderTest.handleLine(testInput);
        classUnderTest.printResult();

        verify(mockOut).println(testInput);
        reset(mockOut);

        classUnderTest.init("1");
        classUnderTest.handleLine(testInput);
        classUnderTest.handleLine("ab");
        classUnderTest.printResult();

        verify(mockOut).println(testInput);
    }

    @Test
    public void testOutputTwoFromThree() throws Exception {
        classUnderTest.init("2");
        classUnderTest.handleLine("ab");
        classUnderTest.handleLine("abcd");
        classUnderTest.handleLine("abcdefg");
        classUnderTest.printResult();

        InOrder order = inOrder(mockOut);
        order.verify(mockOut).println("abcdefg");
        order.verify(mockOut).println("abcd");
        reset(mockOut);

        classUnderTest.init("2");
        classUnderTest.handleLine("abcd");
        classUnderTest.handleLine("ab");
        classUnderTest.handleLine("abcdefg");
        classUnderTest.printResult();

        order = inOrder(mockOut);
        order.verify(mockOut).println("abcdefg");
        order.verify(mockOut).println("abcd");
    }
}
