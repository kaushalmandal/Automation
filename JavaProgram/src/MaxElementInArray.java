import java.util.Scanner;

public class MaxElementInArray {

	public static void main(String[] args) 
	{
		int n=0;
		int max=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the range of an array");
		n=sc.nextInt();
		int[]arr=new int[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
		System.out.println("Max element in an array is " +max);
		

	}

}
