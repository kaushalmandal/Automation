import java.util.Scanner;

public class ReverseWordbyWord {

	public static void main(String[] args) 
	{
		String s="this is india";
		String temp="";
		String str="";
		int len=s.length()-1;
		for(int i=0;i<len;i++)
		{
			temp=temp+s.charAt(i);//this is india
			if((s.charAt(i)==' ')||(i==len))
			{
				for(int j=temp.length()-1;j>=0;j--)
				{
					str=str+temp.charAt(j);
					if((j==0)&&(i!=len))
					{
						str=str+" ";
					}
						
				}
			}
			temp="";
			System.out.println(str);
		}
		

	}

}
