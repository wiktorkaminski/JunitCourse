package junit;

import junit.StringHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper;

    @Before
    public void before() {
        helper = new StringHelper();
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_ANotInFirstPosition() {
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_OneCharacterString() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_EmptyString() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame(""));
    }
}