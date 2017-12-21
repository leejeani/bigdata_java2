package format;

import java.text.MessageFormat;

public class FormatTest4 {

	public static void main(String[] args) {
		String msg = 
			"Name:{0}\tTel:{1}\nAGE:{2}\tID:{3}";
		Person p = new Person("¸»ÀÚ","010","21","id01");

		Object person [] = {p.getName(),p.getTel(),
				20,p.getId()
		};
		String result  = 
				MessageFormat.format(msg, p);
		
		System.out.println(result);
	} 

}




