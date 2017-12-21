package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(2015,0,31); // 2016.1.31
		cal.set(Calendar.HOUR_OF_DAY,10);
		cal.set(Calendar.MINUTE,10);
		cal.set(Calendar.SECOND,10);
		cal.roll(Calendar.MONTH,1);

		SimpleDateFormat sdf1 = 
				new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf1.format(new Date(cal.getTimeInMillis())));
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		Calendar current = Calendar.getInstance();
		
		long differ1 = (current.getTimeInMillis() - 
				cal.getTimeInMillis())/1000;
		System.out.println(differ1);
		System.out.println(differ1/(24*60*60));
		
		final int TIME_UNIT [] = {3600,60,1}; 
		String temp = "";
		for(int i=0;i<TIME_UNIT.length;i++) {
			temp += differ1/TIME_UNIT[i]+" ";
			differ1 %= TIME_UNIT[i];
		}
		System.out.println(temp);
		
		
	}

}



