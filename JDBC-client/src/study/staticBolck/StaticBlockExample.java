package study.staticBolck;

public class StaticBlockExample {
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("study.staticBolck.StaticBlockUsed");
		
		//StaticBlockUsed.m1();
		
	}
	

}
class StaticBlockUsed
{
	//this runs automatically the moment StaticBlockUsed.class is loaded in the Class area in RAM
	static {
		System.out.println("the static block is executed ...");
	}
	
	
	public static void m1()
	{
		System.out.println("m1 called");
	}
}
