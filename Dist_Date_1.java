// Use for Generating a set of Transaction Records for a given date range 
// Transactions have a set of updated interconnected links between multiple columns , therefore these connections should be defined 
// A separate definition method that links can be used (although not part of this code )

import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Random;
import java.time.*;
import java.util.Date.*;
import java.util.Calendar;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;

public class Dist_Date_1
{
	public static void main(String args[])
	{
		int i=0;
		int[] dict =new int[100000];
		int j=0;
		while(j<10)
		{j=storeInt(dict,randInt(0,100));}
		System.out.println("");
                for(int k=0; k<j;k++)
                {System.out.print(dict[k] +":");}
		System.out.println("");
		// Declare todays date 
		LocalDate today=LocalDate.now();
		// Printing bill Dates 
		for(int k=0; k<j;k++)
                {System.out.println(dict[k]+" Days ago"+"  Date"+today.minusDays((dict[k])));}
		// Allocating each day a Number of bills between 1 and  100
		// allocating each entry a unique Bill_Details id and Product Id 
		// Storing above Dict,Date in a json 
		// Create Class for above
		int[] billsIds = new int[100000];
		int z=0;
		while(z<100)
		{z=storeInt(billsIds,randInt(1,10000));}
		//int c,l,f;
		// Inserting Unique Bills_Ids 
		//int m=0;
		//while(m<j)
                //{m=storeInt(billsIds,randInt(1000,100000));}
		ArrayList<billDetails> array = new ArrayList<billDetails>();
		int numBills,alpha;
		alpha=0;
		for (i=0; i<j;i++)
		{
			// Allocating random nunber 1-10 Number of bills to each json
			numBills=randInt(1,10);
			for (int k=0;k<numBills;k++)
			{
			array.add(new billDetails(dict[i],
						today.minusDays((dict[i])),
					        billsIds[alpha],
						//randInt(1000,100000),
						randInt(10000,10000000),
						randInt(1,100)
						));
			alpha++;
			}
		}
		// JSON FORMATION FOR Stroing results
		JSONArray jsonArray =new JSONArray();
		for (i = 0;i < array.size() ; i++) {
			JSONObject obj = new JSONObject();
			obj.put("randInt",  array.get(i).getrandInt());
			obj.put("billDate",  array.get(i).getbillDate());
			obj.put("billDetailsId",  array.get(i).getbillDetailsId());
			obj.put("customerId",  array.get(i).getcustomerId());
			obj.put("productId",  array.get(i).getproductId());
			jsonArray.put(obj);
		}
		try (FileWriter file = new FileWriter("/home/blesson/scripts/utilities/core_java/Dependancy/a.txt")) {
		file.write(jsonArray.toString());
		System.out.println("Successfully Copied JSON Object to File...");
		System.out.println("\nJSON Object: " + jsonArray);
		}  catch(Exception e) {System.out.println(e);}
	}
	// Random Integer Generator
	public static int randInt(int min,int max)
	{
		Random rand=new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	// Search the int Array for int generated
	public static int searchInt(int[] arr, int i)
	{
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]==i)
			{return 1;}
		}
		return -1;
	}
	//Store Unique Int value for given array
	public static int storeInt(int[] arr, int i)
	{
		int searchVal= searchInt(arr,i);
		int a;
		int j=0;
		while (j<arr.length && arr[j]>0)
		{
			j++;
		}
		System.out.println("");
		for(int k=0; k<j;k++)
                {System.out.print(arr[k] +":");}
		if(searchVal==-1) 
		{
			arr[j]=i;
			return j+1;
		}
		return j;

	}
	public static int uniqueBillId(int[] arr,int min,int max)
	{
                Random rand=new Random();
		int ok=-1;
		// Allocate Random Number 
		int randomNum =0;
		// Check if Random Number present in array
		randomNum=rand.nextInt((max - min) + 1) + min;
                while(ok<0)
		{
			// ok=searchInt(arr,randomNum);
			if( searchInt(arr,randomNum)==1)
			{
				randomNum=rand.nextInt((max - min) + 1) + min;
				ok=searchInt(arr,randomNum);
			}
		}
		return randomNum;
	}
}
// Bill Details Class
class billDetails
{
	private int randInt;
	private LocalDate billDate;
	private int billDetailsId;
	private int customerId;
	private int productId;
	
	public billDetails(int randInt,LocalDate billDate,int billDetailsId,int customerId, int productId )
	{
		this.randInt=randInt;
		this.billDate=billDate;
		this.billDetailsId=billDetailsId;
		this.customerId=customerId;
		this.productId=productId;
	}
	// General Getter methods 
	public int getrandInt(){return this.randInt;}
	public LocalDate getbillDate(){return this.billDate;}
	public int getbillDetailsId(){return this.billDetailsId;}
	public int getcustomerId(){return this.customerId;}
	public int getproductId(){return this.productId;}
	// General Setter Methods
        public void setrandInt(int randInt ) {this.randInt=randInt;}
        public void setbillDate(LocalDate billDate) {this.billDate=billDate;}
        public void setbillDetailsId(int billDetailsId) {this.billDetailsId=billDetailsId;}
        public void setcustomerId(int customerId) {this.customerId=customerId;}
        public void setproductId(int productId ) {this.productId=productId;}

}
