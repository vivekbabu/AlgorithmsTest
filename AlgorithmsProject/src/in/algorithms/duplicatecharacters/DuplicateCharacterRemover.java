package in.algorithms.duplicatecharacters;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateCharacterRemover {
    public String removeDuplicateCharacters(String str) {
        if (str == null) return null;
        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }
}
