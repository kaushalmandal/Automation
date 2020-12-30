import java.util.Scanner;

public class ReverseIntegerArray {

	public static void main(String[] args) 
	{
		int n=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the range of an array");
		n=sc.nextInt();
		int[]arr=new int[n];
		System.out.println("Enter the element in an array");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.println("after reverse of an array");
		for(int i=arr.length-1;i>=0;i--)
		{
			System.out.print(" "+arr[i]);
		}

	}

}
