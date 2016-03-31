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
public class RollerCoasterCaseTest {

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
        doReturn(testOutput).when(classUnderTest).applyRollerCoasterCase(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.applyRollerCoasterCase(null));
        assertNull(classUnderTest.applyRollerCoasterCase(""));
    }

    @Test
    public void testStartsWithCaps() throws Exception {
        assertEquals("A", classUnderTest.applyRollerCoasterCase("a"));
        assertEquals("Z", classUnderTest.applyRollerCoasterCase("Z"));
        assertEquals("!H", classUnderTest.applyRollerCoasterCase("!h"));
        assertEquals("     C", classUnderTest.applyRollerCoasterCase("     c"));
    }

    @Test
    public void testAppliesMixedCaps() throws Exception {
        assertEquals("HeLlO wOrLd", classUnderTest.applyRollerCoasterCase("hello world"));
        assertEquals("HeLlO, wOrLd!", classUnderTest.applyRollerCoasterCase("hello, world!"));
    }
}
