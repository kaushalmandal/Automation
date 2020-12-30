package List;

import java.util.ArrayList;
import java.util.Collections;

public class SortingOfArrayList {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("kaushal");
		al.add("kajal");
		al.add("mandal");
		System.out.println("Element in array list is :" + al);
		Collections.sort(al);
		System.out.println("Element in array list is :" + al);

	}

}
