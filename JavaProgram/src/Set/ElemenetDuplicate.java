package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ElemenetDuplicate {

	public static void main(String[] args) {
		String s = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string from user");
		s = sc.nextLine();
		String[] arr = s.split(" ");
		System.out.println("Length of array is :"+arr.length);
		ArrayList<String>al=new ArrayList<String>();
		for(int i=0;i<arr.length;i++)
		{
			al.add(arr[i]);
		}
		System.out.println("Element in array list is :"+al);
		HashSet<String>hs=new HashSet<String>();
		hs.addAll(al);
		System.out.println("Element in hash set is :"+hs);

	}

}
