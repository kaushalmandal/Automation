import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) 
	{
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number from user");
		n=sc.nextInt();
		int rem=0;
		int sum=0;
		int temp=n;
		while(n>0)
		{
			rem=n%10;
			sum=(sum*10)+rem;
			n=n/10;
		}
		if(temp==sum)
		{
			System.out.println("The number is palindrome");
		}
		else
		{
			System.out.println("the number is not palindrome");
		}

	}

}
