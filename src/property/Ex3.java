package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

public class Ex3 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("data2.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 1. ����� ������ �Բ�
		// ������ ���հ� ����� ��� �Ͻÿ�.
		String id = prop.getProperty("id");
		String name = prop.getProperty("name");
		try {
			name = 
			new String(name.getBytes("8859_1"),"KSC5601");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(id+" "+name);
		String score = prop.getProperty("score");
		String [] scores = score.split(",");
		
		int intscore [] = new int[scores.length];
		
		for(int i=0;i<scores.length;i++) {
			intscore[i] = Integer.parseInt(scores[i]);
		}
		
		//System.out.println(Arrays.toString(intscore));
		// 2. ���� �߿� �ִ� ���� �ּ� ���� ��� �Ͻÿ�
		Arrays.sort(intscore);
		System.out.println(intscore[0]);
		System.out.println(intscore[intscore.length-1]);
		
	}

}






