import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestUniqueSubstring {
    /**
     * Implement an algorithm to determine the max length of the unique substring
     */
    public static void main(String[] args) {
        final String case1 = "abcabcdabcde";
        System.out.println(getMaxLengthOfTheUniqueSubstring(case1));

        final String case2 = "abbcbcxa";
        System.out.println(getMaxLengthOfTheUniqueSubstring(case2));
    }

    private static int getMaxLengthOfTheUniqueSubstring(String input) {

        if (input == null || input.isBlank()) {
            return -1;
        }

        if (input.length() == 1) {
            return 1;
        }

        int maxSoFar = Integer.MIN_VALUE;
        int leftPointer = 0, rightPointer = 0;

        Set<Character> uniqueChars = new HashSet<>();

        while (rightPointer < input.length()) {
           if (!uniqueChars.contains(input.charAt(rightPointer))) {
               uniqueChars.add(input.charAt(rightPointer));
               rightPointer +=1;
               maxSoFar = Math.max(uniqueChars.size(), maxSoFar);
           } else {
               uniqueChars.remove(input.charAt(leftPointer));
               leftPointer += 1;
           }
        }
        return maxSoFar;
    }

}
