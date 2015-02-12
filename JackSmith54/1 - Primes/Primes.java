import java.util.Scanner;

public class Primes {
	public static void main(String[] args) {
		int num;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number:");
		num = in.nextInt();
		printPrimes(num);
		in.close();
	}

	static void printPrimes(int num){
		for (int i = 2; i <= num; i++){
			if (isPrime(i)){
				System.out.print(i + " ");
			}
		}
	}
	
	static boolean isPrime(int check) {
		for (int i = 2; i < check/2 + 1; i++) {
			if (check % i == 0) {
				return false;
			}
		}
		return true;
	}
}
