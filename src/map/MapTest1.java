package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MapTest1 {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<>();
		map.put("p1", "this is hashMap");
		map.put("p2", "this is ArrayList");
		map.put("p3", "this is HashSet");
		map.remove("p1");   // delete
		String result = map.get("p2"); // select
		//System.out.println(result);
		map.put("p4","this is ADD Paragraph"); // insert
		map.put("p4","ADD Paragraph"); // update
		
		// Select All
		// 1. key ���� ������ �´�.
		Set<String> keys = map.keySet();
		// 2. ���� ������ �´�.
		// 3. ���� ������ �ͼ� 
		//   ArrayList�� ��ƶ�
		// select all
		ArrayList<String> list = 
				new ArrayList<>();
		for(String key:keys) {
			String str = map.get(key);
			list.add(str);
		}
		
		System.out.println(list);
		
	}

}






