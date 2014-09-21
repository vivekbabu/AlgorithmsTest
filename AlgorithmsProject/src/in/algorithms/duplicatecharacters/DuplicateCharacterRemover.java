package in.algorithms.duplicatecharacters;

public class DuplicateCharacterRemover {
	public static void main(String[] args) {
		String abc = "aaaaaaaaaaaaaraaaaaaaavivaaaaaaaiiiiiivvvvvvvvvaaaaaaddddddddaaaaad";
		String clearedChar = new DuplicateCharacterRemover().removeDuplicateCharacters(
				abc);
		System.out.println(clearedChar);
	}

	public String removeDuplicateCharacters(String s) {
		char ch[] = s.toCharArray();
		int n = ch.length;
		if (n < 2)
			return String.valueOf(ch, 0, n);
		else {
			int current = 1;
			int foward = 1;
			for (; foward < n; foward++) {
				char forwardChar = ch[foward];
				int prev = 0;
				for (; prev < current; prev++) {
					if (ch[prev] == forwardChar)
						break;
				}
				if (prev == current)
					ch[current++] = forwardChar;
			}
			return String.valueOf(ch, 0, current);
		}
	}
}
