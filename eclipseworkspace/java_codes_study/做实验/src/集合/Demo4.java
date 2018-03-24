package ¼¯ºÏ;
import java.util.*;
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList list = new  ArrayList();
//		list.add(new Integer(1));
//		list.add(new Integer(2));
//		list.add(new Integer(3));
//		list.add(new Integer(4));
//		list.add(new Integer(5));
//		list.add(new Integer(6));
//		list.add(1,6);
//		list.set(1, new String("fuck"));
//		Integer i = (Integer)list.get(3);
//		Integer address =(Integer)list.indexOf("fuck");
//		List L =list.subList(0, 2);
//		System.out.println(L);
//		System.out.println(address);
//		System.out.println(i);
//		System.out.println(list);
//		System.out.println(list.size());
//		ListIterator LI = list.listIterator();
//		for(i=0;i<list.size();i++)
//		{
//			System.out.println(LI.next().toString());
//		}
		Map<Integer ,String> map = new HashMap<Integer,String>();
		map.put(1, "01");
		map.put(2, "02");
		map.put(2, "02");
		Set<Map.Entry<Integer, String>> entrySet =map.entrySet();
		Iterator<Map.Entry<Integer, String>> it =entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer, String> me = it.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println("key="+key+"-----value-----"+value);
		}
	}

}

