import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by campbell on 2016/01/19.
 */
public class CalculateDistanceTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    private String buildCoordinatesInput(int point1X, int point1Y, int point2X, int point2Y) {
        return String.format("(%d, %d) (%d, %d)", point1X, point1Y, point2X, point2Y);
    }

    @Test
    public void testZeroPositionAndDistance() throws Exception {
        assertEquals(0, classUnderTest.calculateDistance(buildCoordinatesInput(0, 0, 0, 0)));
    }

    @Test
    public void testSomePositionAndNoDistance() throws Exception {
        assertEquals(0, classUnderTest.calculateDistance(buildCoordinatesInput(4, 2, 4, 2)));
    }

    @Test
    public void testHorizontalOffset() throws Exception {
        assertEquals(1, classUnderTest.calculateDistance(buildCoordinatesInput(0, 0, 1, 0)));
        assertEquals(5, classUnderTest.calculateDistance(buildCoordinatesInput(1, 0, 6, 0)));
    }

    @Test
    public void testVerticalOffset() throws Exception {
        assertEquals(2, classUnderTest.calculateDistance(buildCoordinatesInput(0, 0, 0, -2)));
        assertEquals(15, classUnderTest.calculateDistance(buildCoordinatesInput(0, 5, 0, 20)));
    }

    @Test
    public void testRandomOffset() throws Exception {
        assertEquals(25, classUnderTest.calculateDistance(buildCoordinatesInput(4, 6, 28, 13)));
    }

    @Test
    public void testPrintResult() throws Exception {
        classUnderTest.printResult(buildCoordinatesInput(1, 2, 3, 4));
        verify(mockOut).println(2);
    }
}
