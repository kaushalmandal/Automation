import java.util.Scanner;

public class DigitReverse {

	public static void main(String[] args) 
	{
		int n=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a digit from user");
		n=sc.nextInt();
		int rem=0;
		int res=0;
		while(n>0)
		{
			rem=n%10;
			res=res*10+rem;
			n=n/10;
		}
		System.out.println("Result is :"+res);
		

	}

}
