import java.lang.reflect.Method;


public class Interface1 implements TestInterface {
	
	public void method1()
	{
		System.out.println("implementation method 1");
	}
	
	public void method2()
	{
		System.out.println("implementation method 2");
	}

	
		public static void main(String[] args) {
			
			TestInterface ti= new Interface1();
			int b=ti.a;
			String nam=ti.name;
			System.out.println(b);
			System.out.println(nam);
			ti.method1();
			ti.method2();
			
		}

}
