import java.util.Scanner;

public class FindSecondLargestElementInAnArray {

	public static void main(String[] args) 
	{
		int n=0;
		int max=0;
		int secmax=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the range of an array");
		n=sc.nextInt();
		int[]arr=new int[n];
		System.out.println("Enter the element in an array");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}

		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				secmax=max;
				max=arr[i];
			}
			else if(secmax<arr[i])
			{
				secmax=arr[i];
			}

		}
		System.out.println("second max element in array is : "+secmax);

	}

}
