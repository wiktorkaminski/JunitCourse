package junit;

import junit.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperTestCharacterCheckParameterized {

    StringHelper helper = new StringHelper();
    String input;
    Boolean expectedOutput;

    public StringHelperTestCharacterCheckParameterized(Object input, Object expectedOutput) {
        this.input = (String) input;
        this.expectedOutput = (Boolean) expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object> testCollection() {
        Object[][] expectedOutputs = {
                {"ABCD", false},
                {"ABAB", true},
                {"A", false},
                {"", false}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame() {
        assertEquals(expectedOutput, helper.areFirstAndLastTwoCharactersTheSame(input));
    }
}