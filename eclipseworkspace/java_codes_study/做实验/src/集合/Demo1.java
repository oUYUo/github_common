package ¼¯ºÏ;

import java.util.ArrayList;
import java.util.*;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List list = new ArrayList();
//		list.add("Spring1");
//		list.add("Spring2");
//		list.add("Spring3");
//		list.add("Spring4");
//		for(int i =0;i<list.size();i++)
//		{
//			System.out.println(list.get(i)+";");
//		}
//		List sublist = list.subList(1, 4);
//		System.out.println(sublist);
//		ListIterator it =list.listIterator();
//		it.next();
//		it.next();
//		it.set("Spring5");
//		it.add("Spring6");
//		while(it.hasNext()){
//			System.out.print(it.next());
//		}
//		System.out.println(list);
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "01");
		map.put(2, "02");
		Set<Map.Entry<Integer, String>> entrySet =map.entrySet();
		System.out.println(entrySet);
		Iterator<Map.Entry<Integer, String>> it =entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer, String> me = it.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println("key:"+key+"-----"+"value:"+value);
		}
		System.out.println(map);
		Map<Integer,Object> map2=new HashMap<Integer,Object>();
		map2.put(1,"fuck");
		map2.put(2,222);
		System.out.println(map2);
		Set<Map.Entry<Integer, Object>> entrySet2=map2.entrySet();
		System.out.println(entrySet);
		Iterator<Map.Entry<Integer, Object>> it2=entrySet2.iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer, Object> me2 = it2.next();
			Integer key2 =me2.getKey();
			Object value2 = me2.getValue();
			System.out.println("key:"+key2+"-----"+"value:"+value2);
		}
	}

}
