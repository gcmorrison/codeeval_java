import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/04.
 */
public class AgeDistributionTest {

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
        doReturn(testOutput).when(classUnderTest).calculateAgeDistribution(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertEquals("This program is for humans", classUnderTest.calculateAgeDistribution(null));
        assertEquals("This program is for humans", classUnderTest.calculateAgeDistribution(""));
    }

    @Test
    public void testAliens() throws Exception {
        String expectedAlien = "This program is for humans";
        assertEquals(expectedAlien, classUnderTest.calculateAgeDistribution("-1"));
        assertEquals(expectedAlien, classUnderTest.calculateAgeDistribution("-1645"));
        assertEquals(expectedAlien, classUnderTest.calculateAgeDistribution("101"));
        assertEquals(expectedAlien, classUnderTest.calculateAgeDistribution("6568"));
    }

    @Test
    public void testBaby() throws Exception {
        assertRange("Still in Mama's arms", 0, 2);
    }

    @Test
    public void testPreSchool() throws Exception {
        assertRange("Preschool Maniac", 3, 4);
    }

    @Test
    public void testElementarySchool() throws Exception {
        assertRange("Elementary school", 5, 11);
    }

    @Test
    public void testMiddleSchool() throws Exception {
        assertRange("Middle school", 12, 14);
    }

    @Test
    public void testHighSchool() throws Exception {
        assertRange("High school", 15, 18);
    }

    @Test
    public void testCollege() throws Exception {
        assertRange("College", 19, 22);
    }

    @Test
    public void testWorking() throws Exception {
        assertRange("Working for the man", 23, 65);
    }

    @Test
    public void testRetired() throws Exception {
        assertRange("The Golden Years", 66, 100);
    }

    private void assertRange(String expectedDistribution, int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            assertEquals("Incorrect message for age " + i, expectedDistribution, classUnderTest.calculateAgeDistribution(String.valueOf(i)));
        }
    }
}
