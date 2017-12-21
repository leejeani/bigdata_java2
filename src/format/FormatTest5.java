package format;

import java.text.MessageFormat;

public class FormatTest5 {

	public static void main(String[] args) {
		String msg =
			"INSERT INTO PERSON VALUES (''{0}'',''{1}'',''{2}'',{3});";
		Object [][] persons = 
			{
				{"id01","pwd01","이말숙",20},
				{"id02","pwd02","이말자",30}
			};
		for(Object obj[]: persons) {
			String result = 
			MessageFormat.format(msg, obj);
			System.out.println(result);
		}
	}

}





