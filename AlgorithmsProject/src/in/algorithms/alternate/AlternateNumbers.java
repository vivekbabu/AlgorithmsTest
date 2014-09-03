package in.algorithms.alternate;

public class AlternateNumbers {

	public void alternateTheNumbers(Integer[] elements) {
		int negative = -1, positive = 0;
		while (positive < elements.length) {
			if (elements[positive] < 0) {
				negative++;
				swap(elements, negative, positive);
			}
			positive = positive + 1;
		}
		positive = negative + 1;
		negative = 0;
	
		while(positive < elements.length && negative < positive && elements[negative] < 0) {
			swap(elements,negative, positive);
			negative += 2;
			positive ++;
		}
		
	}

	

	private void swap(Integer[] elements, int current, int forward) {
		int temp = elements[current];
		elements[current] = elements[forward];
		elements[forward] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] elements = new Integer[] {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		new AlternateNumbers().alternateTheNumbers(elements);
		for(int i = 0; i < elements.length ; i++) System.out.print(elements[i] + " ");
	}
	
	

}
