import java.time.*;
import java.util.Date.*;
import java.util.Calendar;
public class Calendar_Test
{
	public static void main(String[] args)
	{
		System.out.println("Printing todays Date");
		System.out.println("Mon     Tue     Wed     Thu     Fri     Sat     Sun");
		LocalDate today=LocalDate.now();
		int day_today=today.getDayOfMonth();
		int month_today=today.getMonthValue();
		// Print numbers for details
		int cnt_month=month_today; 
		LocalDate cnt_date=today.minusDays((day_today-1));
		int value=cnt_date.getDayOfMonth();
		for(int i=1;i<value;i++ )
		{	System.out.print(" ");}
		while (month_today==cnt_month)
		{
			if(cnt_date.getDayOfMonth()==day_today)
				{
					System.out.print(cnt_date.getDayOfMonth()+"*"+"    ");
					cnt_date = cnt_date.plusDays(1);
					month_today=cnt_date.getMonthValue();
					if (cnt_date.getDayOfWeek().getValue()==7) {System.out.print("\n");}
				} 
			else 
				{
					System.out.print(cnt_date.getDayOfMonth()+"    ");
					cnt_date = cnt_date.plusDays(1);
					//LocalDate cnt_date=cnt_date.plusDays(1);
				       	month_today=cnt_date.getMonthValue();
					if (cnt_date.getDayOfWeek().getValue()==7) {System.out.print("\n");}
				} 
		} 

	}
}
