import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Campbell on 2016/01/03.
 */
public class MultiplicationTableTest {
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testMultipleTable() throws Exception {
        assertNotNull(classUnderTest.printResult());
    }

    @Test
    public void testPrintLineFor() throws Exception {
        assertNotNull(classUnderTest.printLineFor(1, 1));
        assertEquals("   1", classUnderTest.printLineFor(1, 1));
        assertEquals("   1   2   3   4   5", classUnderTest.printLineFor(1, 5));
    }
}
