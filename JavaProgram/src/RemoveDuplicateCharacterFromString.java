import java.util.Scanner;

public class RemoveDuplicateCharacterFromString {

	public static void main(String[] args) 
	{
		String s="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any string from user");
		s=sc.nextLine();
		String targetString="";
		char[]ch=s.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(targetString.indexOf(ch[i])==-1)
			{
				targetString=targetString+ch[i];
			}
		}
		System.out.println(targetString);

	}

}
