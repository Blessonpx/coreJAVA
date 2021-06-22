import java.util.*;
import java.io.Console;
import java.io.Reader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Scan_Input
{
	public static void main (String[] args)
	{
		/* Intake Name and Age From the user */
		Scanner in = new Scanner(System.in);
		System.out.println("Hey, Please mention your Name : ");
		String name =in.nextLine();
		System.out.println("Mention your Age : ");
		int age=in.nextInt();
		System.out.println("Hey, "+ name+" your age is : "+age );
		// Intake password from User :
		Console cons=System.console();
		String username = System.console().readLine("User Name :");
		char[] passwd=cons.readPassword("Password: ");
		// Passwords are supposed to be not revealed during any part of the execution
		// After Immediate usage of password , the array should be filled by Filler Values
		String pass=String.valueOf(passwd);
		System.out.println("Password :"+pass);
		// Intake external file 
		try
		{File fileObj=new File("myfile.txt");
		Scanner myReader=new Scanner(fileObj);
		while (myReader.hasNextLine())
		{String data=myReader.nextLine();
			System.out.println(data);}
		myReader.close();} 
		catch (FileNotFoundException e ){
		System.out.println("File not found");
		e.printStackTrace();
		}
	}
}
