package List;

import java.util.ArrayList;
import java.util.Iterator;

public class CloneOfArrayList {

	public static void main(String[] args) 
	{
		ArrayList<String>al=new ArrayList<String>();
		al.add("kaushal");
		al.add("kumar");
		al.add("mandal");
		System.out.println("Element in array list is :"+al);
		Iterator<String>itr=al.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("cloning of arraylist");
		ArrayList<String>clone= (ArrayList<String>)al.clone();
		System.out.println("After cloning");
		System.out.println("Element after clone is :"+clone);

	}

}
