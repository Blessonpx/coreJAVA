import static java.lang.Math.*;
public class MathTest
{
	public static void main(String[] args)
	{
		System.out.println(pow(2,5));
		// This error is passes as unreported with the wrong result 
		System.out.println(1000000000 * 3);
		// This error is handled with an Exception 
		System.out.println(Math.multiplyExact(1000000000, 3) );
	}
}
