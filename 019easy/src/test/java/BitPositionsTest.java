import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by campbell on 2015/12/18.
 */
public class BitPositionsTest {
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testBitPositionsMatch() throws Exception {
        assertEquals("true", classUnderTest.printResult("4,1,2"));
        assertEquals("false", classUnderTest.printResult("4,1,3"));
        assertEquals("true", classUnderTest.printResult("86,2,3"));
        assertEquals("true", classUnderTest.printResult("84,7,3"));
        assertEquals("false", classUnderTest.printResult("125,1,2"));
    }
}
