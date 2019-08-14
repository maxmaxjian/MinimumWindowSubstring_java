import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private String input1;
    private String input2;
    private String expected;
    private Solution soln = new Solution1();

    public SolutionTest(String input1, String input2, String output) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {"ADOBECODEBANC", "ABC", "BANC"},
                {"a", "b", ""}
        });
    }

    @Test
    public void testFunction() {
        assertEquals(expected, soln.minWindow(input1, input2));
    }
}