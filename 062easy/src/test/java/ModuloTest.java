import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by campbell on 2016/01/12.
 */
public class ModuloTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testParseLine() throws Exception {
        assertArrayEquals(new int[]{1, 1}, classUnderTest.parseLine("1,1"));
        assertArrayEquals(new int[]{1, -1}, classUnderTest.parseLine("1,-1"));
        assertArrayEquals(new int[]{-1, -1}, classUnderTest.parseLine("-1,-1"));
        assertArrayEquals(new int[]{0, 123}, classUnderTest.parseLine("0,123"));
    }

    @Test
    public void testCalculateMod() throws Exception {
        assertEquals(0, classUnderTest.calculateMod(0, 1), 0);
        assertEquals(0, classUnderTest.calculateMod(1, 1), 0);
        assertEquals(1, classUnderTest.calculateMod(1, 2), 0);
        assertEquals(2, classUnderTest.calculateMod(5, 3), 0);
        assertEquals(2, classUnderTest.calculateMod(12, 10), 0);
    }

    @Test
    public void testPrintResult() throws Exception {
        classUnderTest.printResult("123,10");
        verify(mockOut).println(3);
    }
}
