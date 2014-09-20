package in.algorithms.stringpermute;

public class StringPermutation {
	
	public void permute(char[] a, int i, int n) {
		if(i==n)System.out.println(a);
		for(int j=i; j <=n; j++) {
			swap(a,i,j);
			permute(a, i+1, n);
			swap(a,i,j);
		}
 	}

	private void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) {
		String string = "ABC";
		new StringPermutation().permute(string.toCharArray(), 0, string.length()-1);
	}
}