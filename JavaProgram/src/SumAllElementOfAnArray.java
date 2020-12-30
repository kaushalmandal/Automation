import java.util.Scanner;

public class SumAllElementOfAnArray {

	public static void main(String[] args) 
	{
		int n=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of an array");
		n=sc.nextInt();
		int[]arr=new int[n];
		int sum=0;
		System.out.println("Enter the elemenet in an array");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
		}
		System.out.println("Sum value is : "+sum);

	}

}
