package strings;

import org.junit.jupiter.api.Test;
import utils.BeautifulStringQuestion;
import utils.StringUtilsExt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class beautifulStringTest {
    BeautifulStringQuestion stringUtilsExt = new BeautifulStringQuestion();

    @Test
    public void testBeautifulStringMethodExists_invalidInput() {
        assertTrue(stringUtilsExt.beautifulString(""));
    }

    @Test
    public void testABCString_valid(){
        assertTrue(stringUtilsExt.beautifulString("abcabc"));
    }

    @Test
    public void testABCString_inValid() {
        assertFalse(stringUtilsExt.beautifulString("abb"));
    }

    @Test
    public void testEndOfAlphabetString_invalid(){
        assertFalse(stringUtilsExt.beautifulString("yyxxzz"));
    }

    @Test
    public void testEndOfAlphabetString_ivalid2(){
        assertFalse(stringUtilsExt.beautifulString("az"));
    }

    @Test
    public void testLongString_valid(){
        assertTrue(stringUtilsExt.beautifulString("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy"));
    }
    @Test
    public void testLongString_invalid(){
        assertFalse(stringUtilsExt.beautifulString("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzzz"));
    }

    @Test
    public void testLongString_invalid2(){
        assertFalse(stringUtilsExt.beautifulString("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwwxxyyzz"));
    }

    @Test
    public void testCapLetters_valid() {
        assertTrue(stringUtilsExt.beautifulString("ABC"));
    }

    @Test
    public void testJumpbledLetters_valid() {
        assertTrue(stringUtilsExt.beautifulString("dccbbaa"));
    }
}
