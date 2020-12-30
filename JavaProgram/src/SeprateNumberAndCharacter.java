import java.util.Scanner;

public class SeprateNumberAndCharacter {

	public static void main(String[] args) 
	{
		String s="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the combination of letter and number");
		s=sc.nextLine();
		String number="";
		int num=0;
		String letter="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>=65 && s.charAt(i)<=90 || s.charAt(i)>=97 && s.charAt(i)<=122)
			{
				letter=letter+s.charAt(i);
			}
			else
			{
				number=number+s.charAt(i);
				num=num*10+s.charAt(i);
				num=Integer.parseInt(number);
			}
			
		}
		System.out.print(letter+" "+num);

	}

}
