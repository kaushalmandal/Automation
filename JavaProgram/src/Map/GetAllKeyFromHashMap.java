package Map;

import java.util.HashMap;
import java.util.Set;

public class GetAllKeyFromHashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "Four");
		hm.put(5, "Five");
		System.out.println("Element in hashmap is :" + hm);
		System.out.println("Get all keys from hashmap");
		Set<Integer>keys=hm.keySet();
		for(Integer key:keys)
		{
			System.out.println(key);
		}

	}

}
