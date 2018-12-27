package java_Programs;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {


		int number=0; int reverseNumber=0; int temp;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Number");
		
		number=s.nextInt();
		
		temp=number;
		while(number!=0)
		{
			/*reverseNumber=reverseNumber*10;
			reverseNumber=reverseNumber+number%10;
			number=number/10;*/
			
			temp=number%10;
			reverseNumber=temp+reverseNumber*10;
			number=number/10;
			
		}
		
		System.out.println("Reverse a Number Pgm:"+reverseNumber);
		
		if(reverseNumber==temp)
		{
			System.out.println("Palindrome");

		}
		else
		{
			System.out.println("Not a Palindrome");
		}
		
		
	}

}
