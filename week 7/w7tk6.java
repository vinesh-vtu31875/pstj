import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int grade = sc.nextInt();

            if (grade >= 38) {
                int next = ((grade / 5) + 1) * 5;
                if (next - grade < 3) {
                    grade = next;
                }
            }

            System.out.println(grade);
        }
    }
}