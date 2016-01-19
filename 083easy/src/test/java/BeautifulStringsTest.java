import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/14.
 */
public class BeautifulStringsTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testOrderStringByOccurrence() throws Exception {
        assertEquals("ab", classUnderTest.orderStringByOccurrence("ab"));
        assertEquals("bba", classUnderTest.orderStringByOccurrence("bab"));
        assertEquals("cccbba", classUnderTest.orderStringByOccurrence("acCcBb"));
    }

    @Test
    public void testCalculateStringBeauty_EmptyInput() throws Exception {
        assertEquals(0, classUnderTest.calculateStringBeauty(null));
        assertEquals(0, classUnderTest.calculateStringBeauty(""));
        assertEquals(0, classUnderTest.calculateStringBeauty(" "));
    }

    @Test
    public void testCalculateStringBeauty_OneLetter() throws Exception {
        assertEquals(26, classUnderTest.calculateStringBeauty("a"));
        assertEquals(26, classUnderTest.calculateStringBeauty("X"));
    }

    @Test
    public void testCalculateStringBeauty_TwoUniqueLetter() throws Exception {
        assertEquals(51, classUnderTest.calculateStringBeauty("aB"));
        assertEquals(51, classUnderTest.calculateStringBeauty("Ba"));
    }

    @Test
    public void testCalculateStringBeauty_MultipleNoSpaces() throws Exception {
        assertEquals(257, classUnderTest.calculateStringBeauty("SeanConnery"));
        assertEquals(292, classUnderTest.calculateStringBeauty("GeorgeLazenby"));
        assertEquals(246, classUnderTest.calculateStringBeauty("RogerMoore"));
        assertEquals(292, classUnderTest.calculateStringBeauty("TimothyDalton"));
        assertEquals(290, classUnderTest.calculateStringBeauty("PierceBrosnan"));
        assertEquals(249, classUnderTest.calculateStringBeauty("DanielCraig"));
    }

    @Test
    public void testCalculateStringBeauty_JamesBondsWithSpaces() throws Exception {
        assertEquals(257, classUnderTest.calculateStringBeauty("Sean Connery"));
        assertEquals(292, classUnderTest.calculateStringBeauty("George Lazenby"));
        assertEquals(246, classUnderTest.calculateStringBeauty("Roger Moore"));
        assertEquals(292, classUnderTest.calculateStringBeauty("Timothy Dalton"));
        assertEquals(290, classUnderTest.calculateStringBeauty("Pierce Brosnan"));
        assertEquals(249, classUnderTest.calculateStringBeauty("Daniel Craig"));
    }

    @Test
    public void testCalculateStringBeauty_JamesBondsWithPunctuation() throws Exception {
        assertEquals(257, classUnderTest.calculateStringBeauty("!!!Sean Connery!!!"));
        assertEquals(292, classUnderTest.calculateStringBeauty("?George Lazenby?"));
        assertEquals(246, classUnderTest.calculateStringBeauty("_Roger Moore_"));
        assertEquals(292, classUnderTest.calculateStringBeauty("Timothy@Dalton"));
        assertEquals(290, classUnderTest.calculateStringBeauty("<Pierce Brosnan>"));
        assertEquals(249, classUnderTest.calculateStringBeauty("!Daniel ?Craig $$"));
    }

    @Test
    public void testCalculateStringBeauty_ProvidedExamples() throws Exception {
        assertEquals(152, classUnderTest.calculateStringBeauty("ABbCcc"));
        assertEquals(754, classUnderTest.calculateStringBeauty("Good luck in the Facebook Hacker Cup this year!"));
        assertEquals(491, classUnderTest.calculateStringBeauty("Ignore punctuation, please :)"));
        assertEquals(729, classUnderTest.calculateStringBeauty("Sometimes test cases are hard to make up."));
        assertEquals(646, classUnderTest.calculateStringBeauty("So I just go consult Professor Dalves"));
    }

    @Test
    public void testPrintResult() throws Exception {
        classUnderTest = spy(classUnderTest);

        int result = 123;
        doReturn(result).when(classUnderTest).calculateStringBeauty(anyString());
        classUnderTest.printResult(UUID.randomUUID().toString());
        verify(mockOut).println(result);
    }
}
