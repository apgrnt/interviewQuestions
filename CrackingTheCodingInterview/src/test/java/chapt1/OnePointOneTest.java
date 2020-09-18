package chapt1;


import org.junit.jupiter.api.Test;
import utils.StringUtilsExt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*
 * Question 1.1
Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures?
*/
public class OnePointOneTest {
	private String uniqueCharsString = "abcdef";
	private String nonUniqueCharsString = "aabbcc";
	
	@Test
	public void uniqueStringTest(){
		assertFalse(StringUtilsExt.dupChars(uniqueCharsString));
	}
	
	@Test
	public void nonUniqueCharsTest(){
		assertTrue(StringUtilsExt.dupChars(nonUniqueCharsString));
	}

}
