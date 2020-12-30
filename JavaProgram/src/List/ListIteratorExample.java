package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorExample {

	public static void main(String[] args) 
	{
		List<Integer>li=new ArrayList<Integer>();
		li.add(23);
		li.add(45);
		li.add(545);
		li.add(2312);
		System.out.println("Element in List is :"+li);
		System.out.println("-------------------------");
		Iterator<Integer> i=li.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		

	}

}
