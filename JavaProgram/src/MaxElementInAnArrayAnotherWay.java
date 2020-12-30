import java.util.Scanner;

public class MaxElementInAnArrayAnotherWay {

	public static void main(String[] args) 
	{
		int n=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of an array");
		n=sc.nextInt();
		System.out.println("Enter the element in an array");
		int[]arr=new int[n];
		int max=0;
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					max=arr[i];
					arr[i]=arr[j];
					arr[j]=max;
				}
			}
		}
		System.out.println("max element is :"+max);

	}

}
