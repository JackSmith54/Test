import java.util.Random;

import javax.management.timer.Timer;


public class ArraySort {
	public static void main(String[] args) {
		int[] array = new int[10000];
		
		generateArray(array);
		arraySort(array);
		System.out.print("Sorted Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	static int[] generateArray(int[] array){
		Random rand = new Random();
		for(int i = 0; i < array.length;i++){
			array[i] = rand.nextInt(10000);
		}
		return array;
	}

	static int[] arraySort(int num[]) {
		int i, j;
		int temp;
		long start = System.currentTimeMillis();
		for (i = 0; i < num.length - 1; i++) {
			for (j = 0; j < num.length - 1; j++) {
				if (num[j] > num[j + 1]) {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
		long stop = System.currentTimeMillis();
		long timer = stop - start;
		System.out.println("Array Sorting took " + timer + " milliseconds");
		return num;
	}
}