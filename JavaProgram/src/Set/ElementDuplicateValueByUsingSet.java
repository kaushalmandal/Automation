package Set;

import java.util.ArrayList;
import java.util.HashSet;

public class ElementDuplicateValueByUsingSet {

	public static void main(String[] args) {
		ArrayList<String>al=new ArrayList<String>();
		al.add("kaushal");
		al.add("kumar");
		al.add("mandal");
		al.add("kajal");
		al.add("mandal");
		System.out.println("Element in array list is :"+al);
		HashSet<String>hs=new HashSet<String>();
		hs.addAll(al);
		System.out.println("Element in hash set is :"+hs);

	}

}
