import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class FindOccurenceOfEachCharacterInTheString {

	public static void main(String[] args) {
		String s = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string from user");
		s = sc.nextLine();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (hm.containsKey(ch[i])) {
				hm.put(ch[i], hm.get(ch[i]) + 1);
			} else {
				hm.put(ch[i], 1);
			}
		}
		System.out.println(hm);
		Set<Character>keys=hm.keySet();
		for(Character key:keys)
		{
			System.out.println(key+"-----------"+hm.get(key));
			
		}

	}

}
