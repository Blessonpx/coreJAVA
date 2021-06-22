import java.util.Scanner;
import static java.lang.Math.*;
public class LotteryDrawing
{
	public static void main(String[] args)
	{
		// Take user input for total and required numbers for lottery
		Scanner in = new Scanner(System.in);
		System.out.println("Mention the total numbers for lottery");
		int N=in.nextInt();
		System.out.println("Mention the lucky numbers you want for lottery");
                int n=in.nextInt();
		// Create Sorted array for numbers for drawing lottery
		int[] T =new int[N];
		for (int i=0; i<T.length;i++)
		{
			T[i]=i+1;
		}
		// Creating separate array for n randomly selected numbers
		int[] t= new int[n];
		System.out.println("Total Tally " + T.length );
                System.out.println("Drawn Tally " + t.length );
		for(int i=0;i<t.length;i++)
		{
			//select random number 
			int r= (int) (Math.random()*N);
			// Allocate Random index from Parnet to child 
			t[i]=T[r];
			// Allocate index r of parent to last index of parent
			T[r]=T[n-1];
			N--;
		}
		System.out.println("Selected Lucky Numbers are :");
		for (int i=0; i<t.length;i++)
		{
			System.out.println(":>>"+t[i]);
		}
	}
}
