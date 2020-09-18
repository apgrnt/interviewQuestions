package chapt2;

import lists.LinkedListTools;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class TwoPointOne {
	private final Object[] cleanedArray = new Object[]{1,2,3,4,5};
	private final LinkedList<Integer> theList = new LinkedList<Integer>();
	
	@Test
	public void testMatches(){
		theList.clear();
		theList.add(1);
		theList.add(2);
		theList.add(3);
		theList.add(4);
		theList.add(5);
		assertArrayEquals(cleanedArray, theList.toArray());
	}
	
	
	@Test
	public void testRemoveDups(){
		cleanLinkedListUnderTest();
		LinkedListTools.removeDuplicates(theList);
		assertArrayEquals(cleanedArray, theList.toArray());
	}


	private void cleanLinkedListUnderTest() {
		theList.clear();
		theList.add(1);
		theList.add(1);
		theList.add(2);
		theList.add(3);
		theList.add(4);
		theList.add(4);
		theList.add(4);
		theList.add(5);
		theList.add(1);
		theList.add(4);
		
	}
	
	@Test
	public void removeDupsNoTempBuffer(){
		cleanLinkedListUnderTest();
		LinkedListTools.removeDuplicatesNoBuffer(theList);
		assertArrayEquals(cleanedArray, theList.toArray());
	}
}