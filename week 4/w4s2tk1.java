import java.util.*;

public class w4s2tk1 {
    public static int[] compareTriplets(int[] a, int[] b) {
        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) {
                alice++;
            } else if (a[i] < b[i]) {
                bob++;
            }
        }

        return new int[]{alice, bob};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[3];
        int[] b = new int[3];

        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextInt();
        }

        int[] result = compareTriplets(a, b);

        System.out.println(result[0] + " " + result[1]);

        sc.close();
    }
}
