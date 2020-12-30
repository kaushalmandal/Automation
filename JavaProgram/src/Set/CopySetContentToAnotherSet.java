package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CopySetContentToAnotherSet {

	public static void main(String[] args) {
		Set<String> se = new HashSet<String>();
		se.add("kaushal");
		se.add("kumar");
		se.add("mandal");
		System.out.println("Element in set is :" + se);
		HashSet<String> hs = new HashSet<String>();
		hs.add("one");
		hs.add("two");
		hs.add("three");
		System.out.println("Element in hash set is :" + hs);
		System.out.println("copying one set to another set");
		hs.addAll(se);
		System.out.println("After copying one set to another set is :" + hs);
		System.out.println("Iterating element one by one");
		Iterator<String> itr = hs.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
