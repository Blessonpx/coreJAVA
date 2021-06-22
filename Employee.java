import java.time.*;
class Employee 
{
	private String name;
	private double salary;
	private LocalDate hireDate ;

	public Employee(String n , int day,int month,int year,double s )
	{
		name=n;
		salary=s;
		hireDate=LocalDate.of(year,month,day);
	}
	public double getSalary()
	{
		return salary ;
	}
	public LocalDate getHireDate()
	{
		return hireDate ;
	}
	public String getName()
	{
		return name;
	}
	public void  increaseSalary(double percentIncrease )
	{
		double x=percentIncrease*salary/100;
		salary=x+salary;

	}
}
