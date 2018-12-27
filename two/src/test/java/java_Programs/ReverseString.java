package java_Programs;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		
		String input="this is test string";
		
		System.out.println(reverseString("Ravi Kiran"));
		System.out.println(reverseString("Ravi "));
		System.out.println(reverseString("Ravi              Kiran"));
		System.out.println(reverseString(""));
		System.out.println(reverseString(" r"));
		System.out.println(reverseString2());
		
		
	}
	
	public static String reverseString(String input)
	{
		String reverse="";
		if(input.isEmpty() || input==null)
		{
			System.out.println("empty and null strings are invalid");
		}
		
		if(input.length()<=1)
		{
			return input;
		}
		else {
		
		String[] output=input.split("\\s+");
		
		for(String result:output)
		{
			reverse=result+ " "+reverse;
		}
		}
		
		return reverse.toUpperCase().trim();
	
	}

	public static String reverseString2()
	{
		String reverse="";
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Data");
		String origional=s.nextLine();
		while(origional.isEmpty() || origional==null)
		{
			System.out.println("Null and Empty string are not valid");
			origional=s.nextLine();
		}
		s.close();
		
		
		String[] output=origional.split("\\s+");
		
		for(String result:output)
		{
			reverse=result+ " "+reverse;
		}
		
		
		return reverse.toUpperCase().trim();
	
	}
}
