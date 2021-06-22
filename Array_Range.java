import java.util.Arrays;
import java.util.*;
public class Array_Range
{
	public static void main(String[] args )
	{
		int[] a=new int[100]; // Declare but but not initialize
		int [] smallPrimes={2,3,5,7,11,13};
		String[] authors ={"JK Rowling","Dan Brown","Neil Geiman"};
		// Anonymous Array
		int[] anonymous= {1,2,3,4,5,6,7,8,9};
		for(int i=0;i<6;i++){
			System.out.println("Echo>>"+smallPrimes[i] );
		}
		// Call array without index
		for (int element :smallPrimes)
		{
			System.out.println("Echo without  index:>>"+element);
		}
		int[] luckynumbers=smallPrimes;
		luckynumbers[5]=12;
		int[] copiedLuckynumbers=Arrays.copyOf(luckynumbers,2*(luckynumbers.length));
		for(int i=0;i<6;i++){
                        System.out.println("EchoSmallPrimes >>"+smallPrimes[i] );
                }
		for(int i=0;i<6;i++){
                        System.out.println("EchoLuckynumbers>>"+luckynumbers[i] );
                }
		for(int i=0;i<6;i++){
                        System.out.println("Echo CopiedLuckyNumbers>>"+copiedLuckynumbers[i] );
                }



	} 
}
