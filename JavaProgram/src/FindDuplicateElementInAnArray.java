import java.util.Scanner;

public class FindDuplicateElementInAnArray {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range of an array");
		n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the element in an array");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.print("The common element in an array is : " + arr[j]);
				}
			}
		}
	}
}