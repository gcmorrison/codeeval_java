import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/01.
 */
public class WorkingExperienceTest {

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
        int testOutput = 5;

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).calculateWorkExperience(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertEquals(0, classUnderTest.calculateWorkExperience(null));
        assertEquals(0, classUnderTest.calculateWorkExperience(""));
    }

    @Test
    public void testLessThanOneYearExperience() throws Exception {
        assertEquals(0, classUnderTest.calculateWorkExperience("Jan 2005-Feb 2005"));
        assertEquals(0, classUnderTest.calculateWorkExperience("Mar 2006-Jan 2007"));
    }

    @Test
    public void testOneYearExperience() throws Exception {
        assertEquals(1, classUnderTest.calculateWorkExperience("Apr 2007-Mar 2008"));
        assertEquals(1, classUnderTest.calculateWorkExperience("Apr 2007-Feb 2009"));
    }

    @Test
    public void testTwoYearsOverlappedExperience() throws Exception {
        assertEquals(2, classUnderTest.calculateWorkExperience("Jul 2009-Dec 2010; Feb 2010-Oct 2011"));
    }

    @Test
    public void testMaxExperience() throws Exception {
        assertEquals(31, classUnderTest.calculateWorkExperience("Jan 1990-Dec 2020"));
    }
}
