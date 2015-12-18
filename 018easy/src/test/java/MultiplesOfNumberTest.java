import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by campbell on 2015/12/18.
 */
public class MultiplesOfNumberTest {
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testMultiples() throws Exception {
        assertEquals(16, classUnderTest.printResult("13,8"));
        assertEquals(32, classUnderTest.printResult("17,16"));
        assertEquals(24, classUnderTest.printResult("17,8"));
    }
}
