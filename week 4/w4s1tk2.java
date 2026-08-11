import java.util.*;

public class w4s1tk2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = s.length();
            int mid = n / 2;

            int[] left = new int[26];
            int[] right = new int[26];

            for (int i = 0; i < mid; i++) {
                left[s.charAt(i) - 'a']++;
            }

            for (int i = (n + 1) / 2; i < n; i++) {
                right[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(left, right)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
