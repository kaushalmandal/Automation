package List;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseOfArrayList {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("kaushal");
		al.add("kumar");
		al.add("mandal");
		al.add("java");
		al.add("python");
		System.out.println("Element in array list is :" + al);
		System.out.println("Reversing of Array list");
		Collections.reverse(al);
		System.out.println("Element in array list is" + al);

	}

}
