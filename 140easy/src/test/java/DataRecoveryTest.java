import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/04.
 */
public class DataRecoveryTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }


    @Test
    public void testPrintResult() throws Exception {
        String testOutput = "testOutput";

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).recoverData(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.recoverData(null));
        assertNull(classUnderTest.recoverData(""));
    }

    @Test
    public void testOneWord() throws Exception {
        assertEquals("word", classUnderTest.recoverData("word;1"));
        assertEquals("noIndex", classUnderTest.recoverData("noIndex;"));
    }

    @Test
    public void testTwoWords() throws Exception {
        assertEquals("hello word", classUnderTest.recoverData("hello word;1 2"));
        assertEquals("hello word", classUnderTest.recoverData("word hello;2 1"));
        assertEquals("hello word", classUnderTest.recoverData("word hello;2"));
    }

    @Test
    public void testMany() throws Exception {
        assertEquals("This is a test", classUnderTest.recoverData("a test This is;3 4 1 2"));
        assertEquals("Is this a test though", classUnderTest.recoverData("a test Is this though;3 4 1 2"));
    }

    @Test
    public void testManyWithPunctuation() throws Exception {
        assertEquals("Look! A distraction!", classUnderTest.recoverData("A distraction! Look!;2 3 1"));
        assertEquals("Well you know what they say..., nothing at all :)",
                classUnderTest.recoverData("they know what you say..., :) Well nothing at all;5 3 4 2 6 10 1"));
    }
}
