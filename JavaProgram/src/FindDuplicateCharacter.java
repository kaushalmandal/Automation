import java.util.Scanner;

public class FindDuplicateCharacter {

	public static void main(String[] args) {
		String s = "";
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string from user");
		s = sc.nextLine();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					
					count++;
					System.out.println("Duplicate character is"+ch[j]);
					break;
				}
			}
		}

	}

}
