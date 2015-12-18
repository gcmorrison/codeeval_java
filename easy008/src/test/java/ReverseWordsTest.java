import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by campbell on 2015/12/18.
 */
public class ReverseWordsTest {
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testReverseWords() throws Exception {
        assertEquals("one", classUnderTest.reverseWords("one"));
        assertEquals("one two", classUnderTest.reverseWords("two one"));
        assertEquals("one two three", classUnderTest.reverseWords("three two one"));
        assertEquals("", classUnderTest.reverseWords(""));
    }
}
