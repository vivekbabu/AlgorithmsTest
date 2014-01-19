package in.algorithms.nextbiggernumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NextBiggerNumber {

	public static void main(String[] args) {
	//	getNextBiggerNumber(53467);	
		// getNextBiggerNumber(54321);
		//getNextBiggerNumber(34722641l);
		getNextBiggerNumber(123456784987654321l);
	}

	private static void getNextBiggerNumber(long i) {
		
		Long[] digits = getNumberAsDigits(i);
		int index = getTheIndexToSwapFrom(digits);
		if (index == -1) {
			System.out.println("No more higher number possible");
		}
		swapTheIndexElementWithTheNextHighestFromRight(digits, index);
		sort(digits, index+1, digits.length);
		long finalNumber = getDigitsAsNumber(digits);
		System.out.println("Next highest = " + finalNumber);
	}

	private static long getDigitsAsNumber(Long[] digits) {
		long finalNumber = 0;
		for(int i = 0; i < digits.length; i++) {
			finalNumber = finalNumber * 10 + digits[i];
		}
		return finalNumber;
	}

	private static Long[] getNumberAsDigits(long i) {
		List<Long> digitsList = new ArrayList<Long>();
		while (i > 0) {
			digitsList.add((i % 10));
			i = i / 10;
		}

		reverse(digitsList);
		Long[] digits = new Long[digitsList.size()];
		digits = (Long[]) digitsList.toArray(digits);
		return digits;
	}

	private static void sort(Long[] digits, int first, int last ) {
		for(int i=first; i < last-1;i++) {
			for(int j= first; j<last-1;j++) {
				if(digits[j]>digits[j+1]) {
					swap(digits, j, j+1);
				}
			}
		}
	}

	private static void swapTheIndexElementWithTheNextHighestFromRight(
			Long[] digits, int index) {
		int i = digits.length - 1;
		long pivotElement = digits[index];
		long nextBiggerToPivotElement = 999;
		int indexOfNextBiggerElement = 0;
		while (i >= index) {
			if (digits[i] > pivotElement
					&& digits[i] < nextBiggerToPivotElement) {
				nextBiggerToPivotElement = digits[i];
				indexOfNextBiggerElement = i;
			}
			i--;

		}
		swap(digits, index, indexOfNextBiggerElement);
	}

	private static void swap(Long[] digits, int index,
			int indexOfNextBiggerElement) {
		long temp = digits[index];
		digits[index] = digits[indexOfNextBiggerElement];
		digits[indexOfNextBiggerElement] = temp;
	}

	private static int getTheIndexToSwapFrom(Long[] digits) {
		int i = digits.length - 2;
		while (i >= 0) {
			if (digits[i] < digits[i + 1]) {
				break;
			}
			i--;

		}
		return i;
	}

	private static void reverse(List<Long> digits) {
		Collections.reverse(digits); 	
	}
}
