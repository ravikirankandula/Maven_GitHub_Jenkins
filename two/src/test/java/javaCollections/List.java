package javaCollections;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.testng.Assert;

import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.LinkedList;

public class List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List is an ordered collection or we can say it follow a sequence to store data
		//List may contain duplicate elements
		//list interface and implementation class are ArrayList, LinkedList, vector
		//you can add any value and u can remove any value
		// you can remove values based on indexs and you can also get index based data
		//there are serveral methods which will he helpful for programmer to  make his jobs super easy
		
		//Collections - List and Map and Set
		//List exposes few methods and these class implement thosemethods
		//when you have list data is availble in your container, how well you mantain with the help of Arraylist is need to know
		
		//Array fixed size, we can't modify its size
		//ArrayList can grow size dynamically, you can increase size by adding and decrease size by remvoing
		
		//you can access and insert value at index
		
		ArrayList<String> actualList=new ArrayList<String>();
		ArrayList<String> verifylist=new ArrayList<String>();
		LinkedList l1=new LinkedList();
		l1.add(1);
		Vector<String> v1=new Vector<>();
		
	/*	al.add("Ravi");
		al.add("selenium");
		System.out.println(al);
		al.add(0, "kandula");
		System.out.println(al);
		al.remove(2);
		System.out.println(al);
		al.remove("Ravi");
		System.out.println(al);*/
		
		//System.out.println(al.get(2).contains("selenium"));
		
		actualList.add("apple");
		
		actualList.add("banana");
		actualList.add("mango");
		actualList.add("grapes");
		actualList.add("custred apple");
		
		System.out.println(actualList);
		
		for(String s:actualList)
		{
			verifylist.add(s);
		}
		System.out.println(verifylist);
		
		Collections.sort(actualList, String.CASE_INSENSITIVE_ORDER);
		System.out.println(actualList);
		//Assert.assertTrue(actualList.contains(verifylist));
		Collections.reverse(actualList);
		System.out.println(actualList);
		Assert.assertTrue(actualList.contains(actualList));
		
	

	}

}
