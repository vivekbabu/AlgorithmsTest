package in.algorithms.java.reversestringwords;

public class ReverseByWord {

    public static char[] reversePart (char[] givenString){
        for (int i=0,j=givenString.length-1; i<givenString.length/2; i++,j--){
            char temp = givenString[i];
            givenString[i] = givenString[j];
            givenString[j] = temp;
        }
        return givenString;
    }
    
    public static void reversePart (char[] givenString,int first, int last){
        for (int i=first,j=last; i<(last-first)/2; i++,j--){
            char temp = givenString[i];
            givenString[i] = givenString[j];
            givenString[j] = temp;
        }
      
    }

    public static String reverseByWord (char[] in){
       // String reversed = String.valueOf(reversePart(in.toCharArray()));
//    	reversePart(in.toCharArray(), 0, in.length());
//        String word_reversal="";
//        int last_space=-1;
//        int j=0;
//        while (j<in.length()){
//            if (reversed.charAt(j)==' '){
//                word_reversal=word_reversal+String.valueOf(reversePart(reversed.substring(last_space+1, j).toCharArray()));
//                word_reversal=word_reversal+" ";
//                last_space=j;
//            }
//            j++;
//        }
//        word_reversal=word_reversal+String.valueOf(reversePart(reversed.substring(last_space+1, in.length()).toCharArray()));
//        return word_reversal;
    	return null;
    }

    public static void main(String[] args) {
        // TODO code application logic here
       // System.out.println(reverseByWord("This is a good test of reversing the words of the String"));
    }
}
