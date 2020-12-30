
public class CommonElementInAnArray {

	public static void main(String[] args) 
	{
		int []arr1={1,4,32,54,2,6455,23};
		int[]arr2={4,2334,32,343,34321,1};
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
				{
					System.out.println(" "+arr2[j]);
				}
			}
		}

	}

}
