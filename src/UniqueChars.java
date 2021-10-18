public class UniqueChars {

    /**
     * Implement an algorithm to determine if a string has all unique characters
     */
    public static void main(String[] args) {
        String case1 = "abcdeaz";
        System.out.println(isUniqueCharString(case1));

        String case2 = "abccde";
        System.out.println(isUniqueCharString(case2));

        String case3 = "abcdezz";
        System.out.println(isUniqueCharString(case3));

        String case4 = "abcdefg";
        System.out.println(isUniqueCharString(case4));

        String case6 = "abcefxyze";
        System.out.println(isUniqueCharString(case6));
    }

    private static boolean isUniqueCharString(final String input) {
        boolean[] allChars = new boolean[128];
        for (char ch : input.toCharArray()) {
            if (allChars[ch]) {
                return false;
            } else {
                allChars[ch] = true;
            }
        }
        return true;
    }

}
