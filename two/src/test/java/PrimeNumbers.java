import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashmap();
		for(int i=2; i<=100; i++)
		{
			for(int j=2; j<=i; j++)
			{
				if(i==j)
				{
					System.out.println(i);
				}
				if(i%j==0)
				{
					break;
				}
				
	
			}
			
		}

	}
	
	
	public static void hashmap()
	{
		HashMap<Integer, String> hm=new HashMap<Integer, String>();
		
		hm.put(1, "Apple");
		hm.put(2, "anar");
		hm.put(23, "test");
		
		System.out.println(hm.get(2));
		hm.remove(23);
		System.out.println(hm);
		
		
		
		Set s=hm.entrySet();
		Iterator ins=s.iterator();
		while(ins.hasNext())
		{
			Map.Entry mp= (Map.Entry)ins.next();
		 System.out.println(mp.getKey());
		 System.out.println(mp.getValue());
		}
	}

}
