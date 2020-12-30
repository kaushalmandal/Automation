import java.util.Arrays;
import java.util.Scanner;

public class SortCharacterInAlphabeticalOrderFromString {

	public static void main(String[] args) {
		String s = "";
		String result = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string from user");
		s = sc.nextLine();
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		System.out.println(new String(ch));
	}

}
