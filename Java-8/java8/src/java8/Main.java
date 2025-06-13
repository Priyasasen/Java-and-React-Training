package java8;
 
public class Main {
 
	public static void main(String[] args) {
		
		
		int a=30,b=30;
		
		calculator sum=(x,y)->(x+y);
		calculator sub=(x,y)->(x-y);
		
		System.out.println(sum.cal(a, b));
		System.out.println(sub.cal(a, b));
		
		
		
 
	}
 
}

 