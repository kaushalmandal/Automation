import java.util.Scanner;

public class PrimeNumberInAnArray {

	public static void main(String[] args) 
	{
		int n=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of an array");
		n=sc.nextInt();
		boolean b=true;
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				System.out.println("the number is not prime :"+n);
				b=false;
				break;
			}
		}
		if(b==true)
		{
			System.out.println("the number is prime :"+n);
		}
		

	}

}
