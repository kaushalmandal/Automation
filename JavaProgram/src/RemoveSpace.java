import java.util.Scanner;

public class RemoveSpace {

	public static void main(String[] args) 
	{
		String s="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any string from user");
		s=sc.nextLine();
		String res="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ')
			{
				res=res+s.charAt(i);
			}
		}
		System.out.println("After removing space result value is");
		System.out.print(res);
		

	}

}
