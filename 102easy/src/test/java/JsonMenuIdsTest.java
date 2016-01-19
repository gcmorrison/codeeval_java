import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/19.
 */
public class JsonMenuIdsTest {

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
        int testSum = 5;

        classUnderTest = spy(classUnderTest);
        doReturn(testSum).when(classUnderTest).sumOfLabeledItemsIds(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testSum);
    }

    @Test
    public void testNoItems() throws Exception {
        assertEquals(0, classUnderTest.sumOfLabeledItemsIds(""));
    }

    @Test
    public void testItemsButNoLabels() throws Exception {
        assertEquals(0, classUnderTest.sumOfLabeledItemsIds("{\"menu\": {\"header\": \"menu\", \"items\": [{\"id\": 81}]}}"));
    }

    @Test
    public void testOneItemWithLabel() throws Exception {
        int testId = 81;
        assertEquals(testId, classUnderTest.sumOfLabeledItemsIds("{\"menu\": {\"header\": \"menu\", \"items\": [{\"id\": " + testId + ", \"label\": \"Label1\"}]}}"));
    }

    @Test
    public void testMultipleItemsWithLabels() throws Exception {
        assertEquals(20, classUnderTest.sumOfLabeledItemsIds("{\"menu\": {\"header\": \"menu\", \"items\": [{\"id\": 5, \"label\": \"Label1\"}, {\"id\": 15, \"label\": \"Label2\"}]}}"));
    }
}
