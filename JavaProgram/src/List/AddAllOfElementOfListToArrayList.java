package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddAllOfElementOfListToArrayList {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("kaushal");
		al.add("kumar");
		al.add("mandal");
		System.out.println("Element in array list is :" + al);
		List<String> li = new ArrayList<String>();
		li.add("kajal");
		li.add("kumari");
		System.out.println("Element in list is :" + li);
		System.out.println("Adding all element of list to array list :");
		al.addAll(li);
		System.out.println("Iterating all element of array list");
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
