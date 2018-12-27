package java_Programs;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		int num=13; int temp=0; int count=0;
		for(int i=2; i<=num; i++)
		{
			if(num%2==0)
			{
				count++;
			}
		}
		if(count==0)
		{
			System.out.println("prime number");
		}
		else
		{
			System.out.println("not a prime number");
		}
		
	}
	}
