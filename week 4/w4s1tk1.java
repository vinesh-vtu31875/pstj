class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < mid; i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                countA++;
            }
        }

        for (int i = mid; i < s.length(); i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                countB++;
            }
        }

        return countA == countB;
    }
}
