package in.algorithms.stringreplacespaces;

public class ReplaceSpaces {
    public static String replaceSpaces(String str) {
        return str.replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith"));
    }
}
