package Set;

import java.util.HashSet;
import java.util.Set;

public class CompareTwoSetAndGetElementWhichAreCommonOnBothSet {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("kaushal");
		hs.add("kumar");
		hs.add("mandal");
		System.out.println("Element in hash set is :" + hs);
		Set<String> se = new HashSet<String>();
		se.add("kajal");
		se.add("mandal");
		System.out.println("Element in set se is" + se);
		System.out.println("Element are common in both set is :");
		System.out.println(" " + hs.retainAll(se));
		System.out.println(hs);

	}

}
