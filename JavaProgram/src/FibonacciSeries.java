import java.util.Scanner;

public class FibonacciSeries {
	public static void main(String[]args)
	{
		int n=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number from user");
		n=sc.nextInt();
		int n1=0;
		int n2=1;
		
		int n3=0;
		System.out.print(n1+" "+n2);
		for(int i=2;i<n;i++)
		{
			n3=n1+n2;
			System.out.print(" "+n3);
			n1=n2;
			n2=n3;
		}
		
	}

}
