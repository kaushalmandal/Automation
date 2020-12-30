import java.util.Scanner;

public class FindMaxCharacterInCharacterArray {

	public static void main(String[] args) 
	{
		String s="";
		char res = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any string from user");
		s=sc.nextLine();
		char[]ch=s.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			for(int j=i+1;j<ch.length;j++)
			{
				if(res<ch[i])
				{
					res=ch[i];
					
				}
			}
		}
		System.out.println("max character in an character array is :"+res);

	}

}
