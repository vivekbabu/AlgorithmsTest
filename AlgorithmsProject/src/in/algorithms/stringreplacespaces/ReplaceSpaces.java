package in.algorithms.stringreplacespaces;

public class ReplaceSpaces {
    public static String replaceSpaces(String str) {
        if (str == null) return null;
        return str.replace(" ", "%20");
    }
}
