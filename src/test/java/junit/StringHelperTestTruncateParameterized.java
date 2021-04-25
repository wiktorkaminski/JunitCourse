package junit;

import junit.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class StringHelperTestTruncateParameterized {

    StringHelper helper = new StringHelper();
    private String input;
    private String expectedOutput;

    public StringHelperTestTruncateParameterized(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testCollection() {
        String[][] expectedOutputs = {
                {"AACD", "CD"},
                {"ACD", "CD"},
                {"CDAA", "CDAA"}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }

}