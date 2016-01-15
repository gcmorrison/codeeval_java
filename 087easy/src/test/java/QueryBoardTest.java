import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Campbell on 2016/01/15.
 */
public class QueryBoardTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testParseParameters() throws Exception {
        assertArrayEquals(new String[]{"a"}, classUnderTest.parseParams("a"));
        assertArrayEquals(new String[]{"a", "b"}, classUnderTest.parseParams("a b"));
        assertArrayEquals(new String[]{"a", "bc", "def"}, classUnderTest.parseParams("a bc def"));
    }

    @Test
    public void testIsValidParameters() throws Exception {
        assertFalse(classUnderTest.isValidOperation(new String[0]));
        assertFalse(classUnderTest.isValidOperation(new String[]{""}));
        assertFalse(classUnderTest.isValidOperation(new String[]{UUID.randomUUID().toString()}));
        assertFalse(classUnderTest.isValidOperation(new String[]{"QueryRow"}));
        assertFalse(classUnderTest.isValidOperation(new String[]{"QueryCol"}));
        assertFalse(classUnderTest.isValidOperation(new String[]{"SetRow"}));
        assertFalse(classUnderTest.isValidOperation(new String[]{"SetCol"}));

        assertFalse(classUnderTest.isValidOperation(new String[]{"SetRow", "1"}));
        assertFalse(classUnderTest.isValidOperation(new String[]{"SetCol", "10"}));

        assertTrue(classUnderTest.isValidOperation(new String[]{"SetRow", "1", "2"}));
        assertTrue(classUnderTest.isValidOperation(new String[]{"SetCol", "10", "20"}));

        assertTrue(classUnderTest.isValidOperation(new String[]{"QueryRow", "1"}));
        assertTrue(classUnderTest.isValidOperation(new String[]{"QueryCol", "10"}));
    }

    @Test
    public void testIsSetCommand() throws Exception {
        assertFalse(classUnderTest.isSetCommand("QueryRow"));
        assertFalse(classUnderTest.isSetCommand("QueryCol"));
        assertTrue(classUnderTest.isSetCommand("SetRow"));
        assertTrue(classUnderTest.isSetCommand("SetCol"));
    }

    @Test
    public void testIsQueryCommand() throws Exception {
        assertFalse(classUnderTest.isQueryCommand("SetRow"));
        assertFalse(classUnderTest.isQueryCommand("SetCol"));
        assertTrue(classUnderTest.isQueryCommand("QueryRow"));
        assertTrue(classUnderTest.isQueryCommand("QueryCol"));
    }

    @Test
    public void testIsRowCommand() throws Exception {
        assertTrue(classUnderTest.isRowCommand("QueryRow"));
        assertFalse(classUnderTest.isRowCommand("QueryCol"));
        assertTrue(classUnderTest.isRowCommand("SetRow"));
        assertFalse(classUnderTest.isRowCommand("SetCol"));
    }

    @Test
    public void testIsColumnCommand() throws Exception {
        assertFalse(classUnderTest.isColumnCommand("SetRow"));
        assertTrue(classUnderTest.isColumnCommand("SetCol"));
        assertFalse(classUnderTest.isColumnCommand("QueryRow"));
        assertTrue(classUnderTest.isColumnCommand("QueryCol"));
    }

    @Test
    public void testHandleSetRow() throws Exception {
        byte[][] assertBoard = new byte[2][2];

        byte setValue = 5;
        int rowIndex = 1;
        assertBoard[0][rowIndex] = setValue;
        assertBoard[1][rowIndex] = setValue;

        byte[][] inputBoard = new byte[2][2];
        assertArrayEquals(assertBoard, classUnderTest.handleSetRow(inputBoard, rowIndex, setValue));

        setValue = 2;
        rowIndex = 0;
        assertBoard[0][rowIndex] = setValue;
        assertBoard[1][rowIndex] = setValue;

        assertArrayEquals(assertBoard, classUnderTest.handleSetRow(inputBoard, rowIndex, setValue));
    }

    @Test
    public void testHandleSetColumn() throws Exception {
        byte[][] assertBoard = new byte[2][2];

        byte setValue = 3;
        int colIndex = 1;
        assertBoard[colIndex][0] = setValue;
        assertBoard[colIndex][1] = setValue;

        byte[][] inputBoard = new byte[2][2];
        assertArrayEquals(assertBoard, classUnderTest.handleSetColumn(inputBoard, colIndex, setValue));

        setValue = 4;
        colIndex = 0;
        assertBoard[colIndex][0] = setValue;
        assertBoard[colIndex][1] = setValue;

        assertArrayEquals(assertBoard, classUnderTest.handleSetColumn(inputBoard, colIndex, setValue));
    }

    @Test
    public void testHandleQueryRow() throws Exception {
        byte[][] assertBoard = new byte[2][2];

        byte setValue = 6;
        int rowIndex = 1;
        assertBoard[0][rowIndex] = setValue;
        assertBoard[1][rowIndex] = setValue;

        assertEquals(12, classUnderTest.handleQueryRow(assertBoard, rowIndex));
    }

    @Test
    public void testHandleQueryColumn() throws Exception {
        byte[][] assertBoard = new byte[2][2];

        byte setValue = 3;
        int colIndex = 1;
        assertBoard[colIndex][0] = setValue;
        assertBoard[colIndex][1] = setValue;

        assertEquals(6, classUnderTest.handleQueryColumn(assertBoard, colIndex));
    }

    @Test
    public void testPrintResult() throws Exception {
        byte[][] board = new byte[2][2];
        classUnderTest.handleOperation(board, "SetRow 1 1");
        classUnderTest.handleOperation(board, "QueryRow 1");
        verify(mockOut).println(2);

        classUnderTest.handleOperation(board, "SetCol 1 5");
        classUnderTest.handleOperation(board, "QueryRow 1");
        verify(mockOut).println(6);
    }
}
