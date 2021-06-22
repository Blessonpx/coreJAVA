public class String1
{
	public static void main(String[] args )
	{
		String greeting="Hello";
		String s=greeting.substring(0,3);
		System.out.println("Hello"+s  );
		System.out.println("Hello "+s+ " \n "  );
		String x="nana",y="NANA";
		Boolean z=x.equals(y);
		System.out.println(z);
		int n=greeting.length();
		System.out.println("n="+n);
		int cpCount=greeting.codePointCount(0,greeting.length());
		System.out.println("cpCount="+cpCount);
		char first=greeting.charAt(0);
		System.out.println("first="+first);
		char last = greeting.charAt(4);
		System.out.println("last="+last);
		int index=greeting.charAt(0);
		System.out.println("index="+index);
		int cp=greeting.charAt(4);
		System.out.println("cp="+ cp);
		String sentence="\u1D54  \u6222 is the set of octonions! ";
		System.out.println("Sentence= "+sentence);


	}
}
