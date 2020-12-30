import java.util.Scanner;

public class PrimeNumberBetweenTwoNumber {

	public static void main(String[] args) 
	{
		int num1,num2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ist number from user");
		num1=sc.nextInt();
		System.out.println("Enter second number from user");
		num2=sc.nextInt();
		boolean b=true;
		for(int i=num1;i<num2;i++)
		{
			for(int j=2;j<num1;j++)
			{
				if(i%j==0)
				{
					b=false;
					break;
				}
				if(b=true)
				{
					System.out.print(" "+i);
				}
			}
		}
		System.out.println();

	}

}
