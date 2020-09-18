package utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * This class tests the methods used in the StringUtilsClass
 */
public class StringUtilsTests {
	
	
	
	@Test
	public void testDupCharsMethod(){
		String uniqueCharsString = "abcdef";
		String nonUniqueCharsString = "aabbcc";
		
		assertFalse(StringUtilsExt.dupChars(uniqueCharsString));
		assertTrue(StringUtilsExt.dupChars(nonUniqueCharsString));
	}
	
	@Test
	public void testIsPermutationsMethod1(){
		String nonPermutation = "abcde"; 
		String permutation1 = "god";     
		String permutation2 = "dog";     
		String nonPermutation2 = "dogg"; 
		assertFalse(StringUtilsExt.arePermutations(nonPermutation, permutation1));
		assertTrue(StringUtilsExt.arePermutations(permutation1, permutation2));
		assertFalse(StringUtilsExt.arePermutations(permutation1, nonPermutation2));
	}
	
}
