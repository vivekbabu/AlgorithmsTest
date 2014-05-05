package in.algorithms.java.reversestringwords;

public class ReverseByWord {

public static void main(String[] args) {
  System.out
      .println(reverseByWords("This is a good test for testing whether reverse works"));
}

private static String reverseByWords(String string) {
  char[] characters = string.toCharArray();
  reverseTheString(characters, 0, characters.length - 1);
  reverseEachWordsInTheString(characters);
  return String.valueOf(characters);
}

private static void reverseEachWordsInTheString(char[] characters) {
  int i = 0, forwardPointer = 0;
  while (i <= characters.length) {
    while (forwardPointer < characters.length
        && characters[forwardPointer] != ' ') {
      forwardPointer++;
    }
    reverseTheString(characters, i, forwardPointer - 1);
    i = forwardPointer = forwardPointer + 1;
  }
}

private static void reverseTheString(char[] characters, int first, int last) {
  int number = (last - first) + 1;
  int middle = 0;
  if (number % 2 == 0) {
    middle = first + (last - first) / 2;
  } else {
    middle = first + (last - first) / 2 - 1;
  }
  System.out.println();
  for (int i = first, j = last; i <= middle; i++, j--) {
    swap(characters, i, j);
  }
}

private static void swap(char[] characters, int i, int j) {
  char temp = characters[i];
  characters[i] = characters[j];
  characters[j] = temp;
}
}
