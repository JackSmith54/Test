import java.util.Scanner;


public class RecursiveFibonacci {
	
	public static void main(String[] args){
		System.out.println("Please enter a positive Integer: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(fibonacci(num) + " is the " + num + "th fibonacci number" );
		scan.close();
	}
	
	static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
