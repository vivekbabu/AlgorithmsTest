package in.algorithms.duplicatecharacters;

import java.util.HashSet;
import java.util.Set;

public class DuplicateCharacterChecker {
    public static boolean checkIfContainsDuplicateCharacters(String str) {
        if (str == null) return false;
        Set<Character> seen = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!seen.add(c)) return true;
        }
        return false;
    }
}
