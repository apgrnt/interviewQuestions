package chapt1;

import org.junit.jupiter.api.Test;
import utils.StringUtilsExt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Given two strings, write a method to decide if one is a permutation of the other.

 */
public class OnePointThreeTest {
	private final String nonPermutation = "abcde";
	private final String permutation1 = "god";
	private final String permutation2 = "dog";
	private final String nonPermutation2 = "dogg";
	
	@Test
	public void nonPermutationTest(){
		assertFalse(StringUtilsExt.arePermutations(nonPermutation, permutation1));
	}
	
	@Test
	public void isPerumtationTest(){
		assertTrue(StringUtilsExt.arePermutations(permutation1, permutation2));
	}
	
	@Test
	public void toLongTest(){
		assertFalse(StringUtilsExt.arePermutations(permutation1, nonPermutation2));
	}
	
}
