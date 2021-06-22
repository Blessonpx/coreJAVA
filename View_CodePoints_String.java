public class View_CodePoints_String
{
	public static void main(String[] args)
	{
		String sentence="\u1D54  \u6222 is the set of octonions! ";
		int j=sentence.length();
		/*
		int i=0;	
		int cp =sentence.codePointAt(i);
		if (Character.isSupplementaryCodePoint(cp)) 
			{ 
				i+=2;
				cp =sentence.codePointAt(i);
				System.out.println(cp);

			}
		else i++;*/

		for(int i=0;i<sentence.length();i++)
			{
				System.out.println("CodePoint for "+sentence.charAt(i)+ "= " + sentence.codePointAt(i));
			}
	}
}

