package Set;

import java.util.HashSet;
import java.util.Iterator;

public class BasicHashSet {

	public static void main(String[] args) 
	{
		HashSet<String>hs=new HashSet<String>();
		hs.add("kaushal");
		hs.add("kumar");
		hs.add("mandal");
		System.out.println("Element in hash set is :"+hs);
		System.out.println("Length of hash set is :"+hs.size());
		System.out.println("Iterating hashset one by one");
		Iterator<String>itr=hs.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}

}
