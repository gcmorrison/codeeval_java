import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/25.
 */
public class RoadTripTest {

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
        doReturn(testOutput).when(classUnderTest).calculateBestRoute(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.calculateBestRoute(null));
        assertNull(classUnderTest.calculateBestRoute(""));
    }

    @Test
    public void testOneCity() throws Exception {
        assertEquals("123", classUnderTest.calculateBestRoute("asdf,123;"));
    }

    @Test
    public void testTwoCities_Ordered() throws Exception {
        assertEquals("123,321", classUnderTest.calculateBestRoute("adf,123; fasef,444;"));
    }

    @Test
    public void testTwoCities_Unordered() throws Exception {
        assertEquals("123,321", classUnderTest.calculateBestRoute("fasef,444; adf,123;"));
    }

    @Test
    public void testFiveCities_Unordered() throws Exception {
        assertEquals("100,100,100,100,100", classUnderTest.calculateBestRoute("vvgh,400; adsf,100; gdfs,300; opiuy,500; ware,200;"));
    }
}
