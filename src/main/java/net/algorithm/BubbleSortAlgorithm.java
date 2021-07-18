/**
 * 
 */
package net.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Khushbu Prajapati
 *
 */
public class BubbleSortAlgorithm {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please tell us the total number of elements to be sort");
			int arraySize = scanner.nextInt();

			System.out.println("Enter the array of elements to be sort followed by space or enter...");

			List<Integer> unsortedList = new ArrayList<Integer>();
			for (int i = 0; i < arraySize; i++) {
				unsortedList.add(scanner.nextInt());
			}
			System.out.println("You have entered total " + unsortedList.size() + " elements...");
			int[] unsortedArray = unsortedList.stream().mapToInt(i -> i).toArray();
			bubbleSort(unsortedArray);
			printElements(unsortedArray, true);
		}
	}

	private static void printElements(int[] sortedArray, boolean finalPrint) {
		if (finalPrint) {
			System.out.println("Final Sorted Elements are as below...");
		}
		String result = "";
		for (int i = 0; i < sortedArray.length; i++) {
			if(i==0) {
				result += "[";
			} 
			if (i != sortedArray.length - 1) {
				result += sortedArray[i] + ", ";
			} else {
				result += sortedArray[i];
			}
			if(i==sortedArray.length-1) {
				result += "]";
			}
		}
		
		System.out.println(result);
	}

	private static void bubbleSort(int[] unsortedArray) {
		for (int i = 0; i < unsortedArray.length; i++) {
			for (int j = 0; j < unsortedArray.length - 1; j++) {
				System.out.println("row(i) - " + i + ", Column(j) - " + j);
				if (unsortedArray[j] > unsortedArray[j + 1]) {
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j + 1];
					unsortedArray[j + 1] = temp;
				}
				printElements(unsortedArray, false);
			}
		}
	}
}
