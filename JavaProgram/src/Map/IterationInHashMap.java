package Map;

import java.util.HashMap;
import java.util.Set;

public class IterationInHashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		System.out.println("value in hash map is :" + hm);
		System.out.println("Iteration in hashmap");
		Set<Integer> keys = hm.keySet();
		for (Integer key : keys) {
			System.out.println("value of " + key + "is" + hm.get(key));
		}

	}

}
