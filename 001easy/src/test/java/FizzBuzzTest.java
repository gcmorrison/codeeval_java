import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Campbell on 2015/12/17.
 */
public class FizzBuzzTest {
    public static final String TEST_FILE = "src\\test\\resources\\dummyFile.txt";

    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main(new String[]{TEST_FILE});
    }

    @Test
    public void testParseInput() throws Exception {
        int testFizz = 3, testBuzz = 5, testRange = 10;
        String line = buildLine(testFizz, testBuzz, testRange);

        int[] params = classUnderTest.parseLine(line);
        assertEquals(testFizz, params[0]);
        assertEquals(testBuzz, params[1]);
        assertEquals(testRange, params[2]);
    }

    @Test
    public void testOutput_OnlyFizz() throws Exception {
        String line = buildLine(2, 4, 3);
        assertEquals("1 F 3", classUnderTest.solveInput(line));
    }

    @Test
    public void testOutput_MultipleFizz() throws Exception {
        String line = buildLine(2, 40, 7);
        assertEquals("1 F 3 F 5 F 7", classUnderTest.solveInput(line));
    }

    @Test
    public void testOutput_OnlyBuzz() throws Exception {
        String line = buildLine(4, 2, 3);
        assertEquals("1 B 3", classUnderTest.solveInput(line));
    }

    @Test
    public void testOutput_MultipleBuzz() throws Exception {
        String line = buildLine(40, 3, 7);
        assertEquals("1 2 B 4 5 B 7", classUnderTest.solveInput(line));
    }

    @Test
    public void testOutput_FizzAndBuzz() throws Exception {
        String line = buildLine(2, 3, 10);
        assertEquals("1 F B F 5 FB 7 F B F", classUnderTest.solveInput(line));
    }

    private String buildLine(int fizz, int buzz, int range) {
        return String.format("%d %d %d", fizz, buzz, range);
    }
}
