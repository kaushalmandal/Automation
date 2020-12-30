import java.util.Scanner;

public class PalindromeString 
{
	public static void main(String[]args)
	{
		String reverse="";
		String s="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string from user");
		s=sc.nextLine();
		for(int i=s.length()-1;i>=0;i--)
		{
			reverse=reverse+s.charAt(i);
		}
		if(s.equals(reverse))
		{
			System.out.println("yes the string is palindrome");
		}
		else
		{
			System.out.println("no the string is not palindrome");
		}
		
		
	}

}
