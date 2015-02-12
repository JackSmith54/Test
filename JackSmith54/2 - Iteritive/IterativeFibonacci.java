import java.util.Scanner;


public class IterativeFibonacci {

		public static void main(String[] args){
			System.out.println("Please enter a positive Integer: ");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			System.out.println(fibonacci(num) + " is the " + num + "th fibonacci number" );
			scan.close();
		}
		
		static int fibonacci(int n) {

			int a = 0;
			int count = 0;
			int b = 1;

			if (n == 0) {
				return 0;
			} else if (n == 1) {
				return 1;
			} else if (n == 2) {
				return 1;
			} else {
				for (int i = 1; i < n; i++) {
					count = a + b;
					a = b;
					b = count;
				}
				return count;
			}
		}
}
