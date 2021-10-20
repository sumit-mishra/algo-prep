import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestUniqueSubstring {
    /**
     * Implement an algorithm to determine the max length of the unique substring
     */
    public static void main(String[] args) {
        final String case1 = "abcabcdabcde";
        System.out.println(getMaxLengthOfTheUniqueSubstring2(case1));

        final String case2 = "abbcbcxa";
        System.out.println(getMaxLengthOfTheUniqueSubstring2(case2));
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

    //solution 2 -- better solution
    private static int getMaxLengthOfTheUniqueSubstring2(String input) {
        int maxSoFar = 0, currentMax = 0;
        boolean[] uniqueChars = new boolean[128];

        for (int i = 0; i < input.length(); i++) {
            if (uniqueChars[input.charAt(i)]) {
                maxSoFar = Math.max(maxSoFar, currentMax);
                uniqueChars = new boolean[128];
                currentMax = 1;
                uniqueChars[input.charAt(i)] = true;
            } else {
                currentMax += 1;
                uniqueChars[input.charAt(i)] = true;
            }
        }
        maxSoFar = Math.max(currentMax, maxSoFar);
        return maxSoFar;
    }

}
