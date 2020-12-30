package List;

import java.util.ArrayList;
import java.util.Collections;

public class SwapTwoElementInArrayList {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("kaushal");
		al.add("kumar");
		al.add("mandal");
		al.add("java");
		al.add("selenium");
		al.add("python");
		System.out.println("Element in array list is:" + al);
		System.out.println("Swapping two element");
		Collections.swap(al, 2, 5);
		System.out.println("After swapped");
		System.out.println("Element in array list is :" + al);

	}

}
