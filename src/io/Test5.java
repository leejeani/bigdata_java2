package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test5 {

	public static void main(String[] args) {
		int data [] = {100,90,80,70};
		
		try(FileOutputStream fos = new FileOutputStream("data.dat");
			DataOutputStream dos = new DataOutputStream(fos)){
			
			for(int d:data) {
				dos.writeInt(d);
			}
			
		}catch(Exception e) {
			
		}
			
	    // ������ �����͸� �о� �鿩
		// ���ڵ��� ���� ���Ѵ�
		int sum = 0;
		
		try(FileInputStream fis = new FileInputStream("data.dat");
				DataInputStream dis = new DataInputStream(fis)){
			
			while(true) {
				int score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
				
		}catch(Exception e) {
				//e.printStackTrace();
		}
		
		
		System.out.println(sum);
		
		
	}

}




