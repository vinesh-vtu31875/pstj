import java.util.*;

public class w5s2tk1 {
    public static List<Integer> maxSubarray(List<Integer> arr) {
        int current = arr.get(0);
        int maxSubarray = arr.get(0);
        int maxElement = arr.get(0);
        int maxSubsequence = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int x = arr.get(i);

            current = Math.max(x, current + x);
            maxSubarray = Math.max(maxSubarray, current);

            maxElement = Math.max(maxElement, x);

            if (x > 0) {
                maxSubsequence += x;
            }
        }

        if (maxElement < 0) {
            maxSubsequence = maxElement;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Integer> result = maxSubarray(arr);
            System.out.println(result.get(0) + " " + result.get(1));
        }
    }
}
