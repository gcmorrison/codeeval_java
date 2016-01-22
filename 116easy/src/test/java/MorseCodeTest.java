import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/22.
 */
public class MorseCodeTest {

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
        doReturn(testOutput).when(classUnderTest).decodeMorseCode(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.decodeMorseCode(null));
        assertNull(classUnderTest.decodeMorseCode(""));
    }

    @Test
    @Ignore
    public void testSpace() throws Exception {
        assertEquals(" ", classUnderTest.decodeMorseCode("  "));
    }

    @Test
    public void testOneCodeLetters() throws Exception {
        assertEquals("E", classUnderTest.decodeMorseCode("."));
        assertEquals("T", classUnderTest.decodeMorseCode("-"));
    }

    @Test
    public void testTwoCodeLetters() throws Exception {
        assertEquals("I", classUnderTest.decodeMorseCode(".."));
        assertEquals("A", classUnderTest.decodeMorseCode(".-"));
        assertEquals("N", classUnderTest.decodeMorseCode("-."));
        assertEquals("M", classUnderTest.decodeMorseCode("--"));
    }

    @Test
    public void testThreeCodeLetters() throws Exception {
        assertEquals("S", classUnderTest.decodeMorseCode("..."));
        assertEquals("U", classUnderTest.decodeMorseCode("..-"));
        assertEquals("R", classUnderTest.decodeMorseCode(".-."));
        assertEquals("W", classUnderTest.decodeMorseCode(".--"));
        assertEquals("D", classUnderTest.decodeMorseCode("-.."));
        assertEquals("K", classUnderTest.decodeMorseCode("-.-"));
        assertEquals("G", classUnderTest.decodeMorseCode("--."));
        assertEquals("O", classUnderTest.decodeMorseCode("---"));
    }

    @Test
    public void testFourCodeLetters() throws Exception {
        assertEquals("H", classUnderTest.decodeMorseCode("...."));
        assertEquals("V", classUnderTest.decodeMorseCode("...-"));
        assertEquals("F", classUnderTest.decodeMorseCode("..-."));
        // Unused code: ..--
        assertEquals("L", classUnderTest.decodeMorseCode(".-.."));
        // Unused code: .-.-
        assertEquals("P", classUnderTest.decodeMorseCode(".--."));
        assertEquals("J", classUnderTest.decodeMorseCode(".---"));
        assertEquals("B", classUnderTest.decodeMorseCode("-..."));
        assertEquals("X", classUnderTest.decodeMorseCode("-..-"));
        assertEquals("C", classUnderTest.decodeMorseCode("-.-."));
        assertEquals("Y", classUnderTest.decodeMorseCode("-.--"));
        assertEquals("Z", classUnderTest.decodeMorseCode("--.."));
        assertEquals("Q", classUnderTest.decodeMorseCode("--.-"));
        // Unused code: ---.
        // Unused code: ----
    }

    @Test
    public void testEAndT() throws Exception {
        assertEquals("ET", classUnderTest.decodeMorseCode(". -"));
    }

    @Test
    public void testESpaceT() throws Exception {
        assertEquals("E T", classUnderTest.decodeMorseCode(".  -"));
    }

    @Test
    public void testAlphabeth() throws Exception {
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", classUnderTest.decodeMorseCode(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.."));
    }

    @Test
    public void testNumberZero() throws Exception {
        assertEquals("0", classUnderTest.decodeMorseCode("-----"));
    }

    @Test
    public void testNumbers2And5AndEight() throws Exception {
        assertEquals("2", classUnderTest.decodeMorseCode("..---"));
        assertEquals("5", classUnderTest.decodeMorseCode("....."));
        assertEquals("8", classUnderTest.decodeMorseCode("---.."));
    }

    @Test
    public void testNumbers() throws Exception {
        assertEquals("0123456789", classUnderTest.decodeMorseCode("----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----."));
    }

    @Test
    public void testSpaceSeparated() throws Exception {
        assertEquals("A I", classUnderTest.decodeMorseCode(".-  .."));

    }

    @Test
    public void testWords() throws Exception {
        assertEquals("HELLO WORLD 294", classUnderTest.decodeMorseCode(".... . .-.. .-.. ---  .-- --- .-. .-.. -..  ..--- ----. ....-"));
    }
}
