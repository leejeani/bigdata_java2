package format;

import java.text.DecimalFormat;
import java.text.ParseException;

public class FormatTest {

	public static void main(String[] args) {
		int num1 = 1000000;
		double num2 = 10000.1289;
		
		DecimalFormat df1 = 
				new DecimalFormat("\u00A4 #,###");
		DecimalFormat df2 = 
				new DecimalFormat("#,###.###%");
		
		String snum1 = df1.format(num1);
		String snum2 = df2.format(num2);
		
		System.out.println(snum1);
		System.out.println(snum2);
		Number num = null;
		try {
			num = df1.parse(snum1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int intnum = num.intValue();
		intnum += 2000;
		System.out.println(df1.format(intnum));
		
		
		
	}

}



