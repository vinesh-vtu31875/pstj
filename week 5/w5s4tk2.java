import java.util.*;

public class w5s3tk4 {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    public static boolean matches(String word, String pattern) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (map1.containsKey(w) && map1.get(w) != p) {
                return false;
            }

            if (map2.containsKey(p) && map2.get(p) != w) {
                return false;
            }

            map1.put(w, p);
            map2.put(p, w);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        String pattern = sc.next();

        List<String> result = findAndReplacePattern(words, pattern);

        for (String word : result) {
            System.out.print(word + " ");
        }

        sc.close();
    }
}