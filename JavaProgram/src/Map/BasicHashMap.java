package Map;

import java.util.HashMap;

public class BasicHashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		System.out.println("Element in hashmap is :" + hm);
		System.out.println("size of hashmap is :" + hm.size());
		System.out.println("get the value of 2nd key");
		hm.get(2);
		System.out.println("is hashmap empty :" + hm.isEmpty());
		System.out.println("Removing 3rd element");
		hm.remove(3);
		System.out.println("Element in hm is :" + hm);
		System.out.println("size of hashmap is :" + hm.size());

	}

}
