package javaCollections;

import java.util.HashMap;

public class Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer,String> mp= new HashMap<Integer, String>();
		
		mp.put(1, "Ravi");
		mp.put(2, "Kiran");
		
		System.out.println(mp.get(1));
		System.out.println(mp.get(2).contains("Kiran"));
		

	}

}
