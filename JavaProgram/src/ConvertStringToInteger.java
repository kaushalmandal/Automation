import java.util.Scanner;

public class ConvertStringToInteger {
	public static void main(String[] args) {
		String s = "";
		String resultString = "";
		int result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string from user");
		s = sc.nextLine();
		result = Integer.parseInt(s);
		System.out.println("Reslt value in string is :" + s);
		System.out.println("convert resulted integer into string");
		resultString = Integer.toString(result);
		System.out.println("Integer into string is :" + resultString);
		
		// convert integer into string in another way
		
		String strValue=result+"";
		System.out.println(strValue);
	}

}
