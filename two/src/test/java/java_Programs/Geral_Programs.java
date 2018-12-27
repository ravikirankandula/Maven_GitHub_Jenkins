package java_Programs;

import java.util.Scanner;

public class Geral_Programs {

	public static void main(String[] args) {
		
		int result=add(4,5);
		System.out.println(result);
		System.out.println(max2numbers());

	}
	
	public static Integer add(int a, int b)
	{
		int c;
		
		return c=a+b;
	}
	
	public static int max2numbers()
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter number 1");
		Integer a1=scan.nextInt();
		System.out.println("Enter number 2");
		Integer a2=scan.nextInt();
		
		if(a1>a2)
		{
			return a1;
		}
		else {
			return a2;
		}
		
		
		
	}

}
