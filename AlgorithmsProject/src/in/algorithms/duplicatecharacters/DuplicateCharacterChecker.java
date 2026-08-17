package in.algorithms.duplicatecharacters;

public class DuplicateCharacterChecker {
    public static boolean checkIfContainsDuplicateCharacters(String sentence) {
        boolean[] charBooleans = new boolean[256];
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (charBooleans[c]) return true;
            charBooleans[c] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfContainsDuplicateCharacters("Aabc"));
        System.out.println(checkIfContainsDuplicateCharacters("Vivek babu"));
    }
}
