package List;

import java.util.ArrayList;
import java.util.List;

public class FindDoesArrayListContainsAllListElementsOrNot {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("kaushal");
		al.add("kumar");
		al.add("mandal");
		System.out.println("Element in array list :" + al);
		List<String> li = new ArrayList<String>();
		li.add("kumar");
		li.add("mandal");
		System.out.println("checking arraylist contains all list element or not");
		System.out.println(al.containsAll(li));
		li.add("kajal");
		System.out.println(al.contains(li));

	}

}
