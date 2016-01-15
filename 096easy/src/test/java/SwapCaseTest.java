import org.junit.Before;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;

/**
 * Created by Campbell on 2016/01/15.
 */
public class SwapCaseTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    // TODO
}
