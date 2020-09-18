package lists;

import java.util.Hashtable;
import java.util.LinkedList;

public class LinkedListTools {
	
	
	public static <E> void removeDuplicates(LinkedList<E> linkedList){
		Hashtable occurences = new Hashtable();
		for(int i = 0; i < linkedList.size(); i++){
			if(!occurences.containsKey(linkedList.get(i))){
				occurences.put(linkedList.get(i), true);
			}else {
				linkedList.remove(i);
				i--;
			}
		}
	}

	public static <E> void removeDuplicatesNoBuffer(LinkedList<Integer> theList) {
		for(int i = 0; i < theList.size(); i++){
			for(int x = i+1; x < theList.size(); x++){
				if(theList.get(i).equals(theList.get(x))){
					theList.remove(x);
					x--;
				}
			}
		}
	}
	

}
