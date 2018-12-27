package java_Programs;

public class ReverseCharactersInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input="this is test string";
		
		String reverse="";
		
		for(int i=input.length()-1; i>=0; i--)
		{
			reverse= reverse+input.charAt(i);
			System.out.println(reverse);
		}
		System.out.println(reverse);

	}

}
