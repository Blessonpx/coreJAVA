import java.time.*;

public class EmployeeTest
{
	public static void main(String[] args)
	{
		Employee[] staff=new Employee[2];
		staff[0]=new Employee("Blesson",16,1,1993,100000 );
		staff[1]=new Employee("Benson",1,1,1998,100000);
		for (Employee e:staff)
		{e.increaseSalary(10); }
		
		for (Employee e:staff)
		{System.out.println("Name: "+e.getName()+"  Date of Hire : "+ e.getHireDate()  + " Salary:  "+e.getSalary()); }
	}
}

