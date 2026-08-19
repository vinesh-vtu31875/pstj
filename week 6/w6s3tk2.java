import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] count = new int[26];

        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int needed = p.length();

        while (right < s.length()) {
            int index = s.charAt(right) - 'a';

            if (count[index] > 0) {
                needed--;
            }

            count[index]--;
            right++;

            if (right - left == p.length()) {
                if (needed == 0) {
                    result.add(left);
                }

                int leftIndex = s.charAt(left) - 'a';

                if (count[leftIndex] >= 0) {
                    needed++;
                }

                count[leftIndex]++;
                left++;
            }
        }

        return result;
    }
}