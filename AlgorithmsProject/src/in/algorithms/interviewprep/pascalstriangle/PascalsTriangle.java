package in.algorithms.interviewprep.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

// LeetCode 118: Pascal's Triangle - https://leetcode.com/problems/pascals-triangle/description/
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> firstList = List.of(1);

        finalList.add(firstList);

        for(int i = 1; i < numRows; i++) {

            List<Integer> prevList = finalList.get(i - 1);
            List<Integer> currentList = new ArrayList<>();
            int currentElement, prevElement;

            for(int j =0; j <= prevList.size(); j++) {
                prevElement = j < 1 ? 0 : prevList.get(j-1);
                currentElement = j == prevList.size()? 0 : prevList.get(j);
                currentList.add(prevElement + currentElement);
            }
            finalList.add(currentList);
        }
        return finalList;
    }
}
