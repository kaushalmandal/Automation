package List;

import java.util.ArrayList;
import java.util.Iterator;

public class DeleteAllElementOfList {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("kaushal");
		al.add("kumar");
		al.add("mandal");
		System.out.println("Element in list is :" + al);
		System.out.println("Iterating element one by one");
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("Delete all element from list :");
		al.clear();
		System.out.println("Element in arrayList is :"+al);

	}

}
