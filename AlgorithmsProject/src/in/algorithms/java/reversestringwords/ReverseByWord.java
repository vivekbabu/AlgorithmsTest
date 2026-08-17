package in.algorithms.java.reversestringwords;

import org.apache.commons.lang3.StringUtils;

public class ReverseByWord {
    public static String reverseByWords(String string) {
        if (StringUtils.isEmpty(string)) {
            return string;
        }
        char[] charArray = string.toCharArray();
        reverse(charArray, 0, charArray.length - 1);
        int first = 0;
        int last = 0;
        while (first < charArray.length) {
            if (last < charArray.length && charArray[last] != ' ') {
                last++;
            } else {
                reverse(charArray, first, last - 1);
                last++;
                first = last;
            }
        }
        return new String(charArray);
    }

    public static void reverse(char[] charArray, int first, int last) {
        if (charArray == null || first >= last || first < 0 || last >= charArray.length) {
            return;
        }
        while (first < last) {
            char temp = charArray[first];
            charArray[first] = charArray[last];
            charArray[last] = temp;
            first++;
            last--;
        }
    }
}
