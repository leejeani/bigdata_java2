package format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatTest2 {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf1 
		= new SimpleDateFormat("''yy-MM-dd Eø‰¿œ a HH:mm:ss.SSS");
		SimpleDateFormat sdf2 
		= new SimpleDateFormat("D");

		String sdate1 = sdf1.format(date);
		System.out.println(sdate1);
		
		String sdate2 = sdf2.format(date);
		System.out.println(sdate2);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf3
		= new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss.SSS");
		Date cdate = cal.getTime();
		String sdate3 = sdf3.format(cdate);
		System.out.println(sdate3);
		
		Date d = null;
		try {
			 d = sdf3.parse(sdate3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
		
	}

}







