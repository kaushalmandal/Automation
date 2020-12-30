package Map;

import java.util.HashMap;
import java.util.Set;

public class CopyMapContentToAnotherMap {
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		System.out.println("value in hashmap is :" + hm);
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(6, "six");
		hashmap.put(7, "seven");
		hashmap.put(8, "Eight");
		hashmap.putAll(hm);
		System.out.println("value of hash map is :" + hashmap);
		Set<Integer> key = hashmap.keySet();
		for (Integer keys : key) {
			System.out.println(keys+"-------------"+hashmap.get(keys));

		}
	}

}
