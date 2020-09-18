package chapt1;


import org.junit.jupiter.api.Test;
import utils.StringUtilsExt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * ONE AWAY: There are three types of edits that can be performed on strings: insert a character, remove a char, or replace a char. 
 * Given two strings, write a function to check if they are one one edit (or zero edits) away.
 * Example
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OnePointFiveTest {
    
    @Test
    public void sameWord(){
        assertTrue(StringUtilsExt.oneEditAway("pale", "pale"));
    }
    
    @Test
    public void oneEditAwaySameLength(){
	assertTrue(StringUtilsExt.oneEditAway("pale", "prle"));
    }
    
    @Test
    public void oneEditAwaySecond(){
	        assertTrue(StringUtilsExt.oneEditAway("pale", "pare"));
    }
    
    @Test
    public void oneEditAwayThirst(){
	assertTrue(StringUtilsExt.oneEditAway("pale", "palr"));
    }
    
    @Test
    public void oneEditAwayFourth(){
	assertTrue(StringUtilsExt.oneEditAway("pale", "rale"));
    }
    
    @Test
    public void oneEditAwayDiffLengthFirstWordLonger(){
	assertTrue(StringUtilsExt.oneEditAway("pale", "ple"));
    }
    
    @Test
    public void oneEditAwayDiffLengthSecondLonger(){
	assertTrue(StringUtilsExt.oneEditAway("pale", "pales"));
    }
    
    @Test
    public void oneEditAwayFalse(){
	assertFalse(StringUtilsExt.oneEditAway("pale", "bake"));
	assertFalse(StringUtilsExt.oneEditAway("bake", "pale"));
	assertFalse(StringUtilsExt.oneEditAway("largeString", "one"));
	assertFalse(StringUtilsExt.oneEditAway("one", "reallyLongString"));
    }

}
