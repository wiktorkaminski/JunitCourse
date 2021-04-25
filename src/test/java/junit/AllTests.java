package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArraysCompareTest.class,
        StringHelperTest.class,
        StringHelperTestTruncateParameterized.class,
        StringHelperTestCharacterCheckParameterized.class
})
public class AllTests {
}
