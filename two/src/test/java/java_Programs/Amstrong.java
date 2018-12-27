package java_Programs;

public class Amstrong {

	public static void main(String[] args) {
		
		int num=371, temp=0, amstrongnumber=0; int check=0;
		check=num;
		while(num>0)
		{
			amstrongnumber=num%10;
			num=num/10;
			temp=temp+(amstrongnumber*amstrongnumber*amstrongnumber);
		}
		if(temp==check)
		{
			System.out.println("Amstrong Number");
		}
		
		else
		{
			System.out.println("Not a Amstrong Number");
		}

	}

}
