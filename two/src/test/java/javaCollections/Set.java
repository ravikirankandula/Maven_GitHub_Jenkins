package javaCollections;

import java.util.HashSet;
import java.util.Iterator;

public class Set {

	public static void main(String[] args) {
		
		//Set Interface
		//HashSet, TreeSet, LinkedHashSet are implementing class's for Set interface
		//diff btw list and set is Set will not allow duplicate elements, It may not follow any sequence order
		
		HashSet<String> hs=new HashSet<String>();
		hs.add("91");
		hs.add("22");
		
		hs.add("13");
		hs.add("42");
		hs.add("2");
		System.out.println(hs);
		hs.isEmpty();
		Iterator<String> is=hs.iterator();
		while(is.hasNext())
		{
			System.out.println(is.next());
		}
		
	}

}
