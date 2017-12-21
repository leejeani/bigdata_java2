package format;

import java.text.ChoiceFormat;

public class FormatTest3 {

	public static void main(String[] args) {
//		double [] score = {60,70,80,90};
//		String [] grade = {"D","C","B","A"};
		
		String pattern = "50<F|61#D|71#C|81#B|91#A";
		int [] sc = {98,50,67,80,89,92};
		
//		ChoiceFormat form = 
//				new ChoiceFormat(score,grade);
		ChoiceFormat form = 
				new ChoiceFormat(pattern);
		for(int i : sc) {
			System.out.println(i+" "+form.format(i));
		}
	}

}






