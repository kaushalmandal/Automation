package List;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicArrayList {

	public static void main(String[] args) 
	{
		ArrayList<Integer>al=new ArrayList<Integer>();
		al.add(34);
		al.add(454);
		al.add(23);
		System.out.println("Element in array list is :"+al);
		System.out.println("Element at index 1 is :"+al.get(1));
		al.add(2,100);
		System.out.println("element in array list is :"+al);
		System.out.println("size of list is " +al.size());
		Iterator<Integer>i=al.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

	}

}
