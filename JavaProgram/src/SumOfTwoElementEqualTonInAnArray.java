
public class SumOfTwoElementEqualTonInAnArray {

	public static void main(String[] args) 
	{
		int sum=9;
		int[]arr={1,4,5,2,3,9};
		for(int i=0;i<arr.length;i++)
		{
			for(int j=arr.length-1;j>=0;j--)
			{
				if(arr[i]+arr[j]<sum)
				{
					break;
				}
				if(arr[i]+arr[j]==sum)
				{
					System.out.println(arr[i]+"------"+arr[j]+" = "+sum);
				}
			}
		}

	}

}
