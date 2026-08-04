import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    public PerformOperation isPrime() {
        return (int a) -> {
            if (a < 2) return false;
            for (int i = 2; i <= Math.sqrt(a); i++)
                if (a % i == 0) return false;
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return (int a) -> {
            int t = a, r = 0;
            while (t > 0) {
                r = r * 10 + t % 10;
                t /= 10;
            }
            return r == a;
        };
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (ch == 1)
                System.out.println(MyMath.checker(ob.isOdd(), num) ? "ODD" : "EVEN");
            else if (ch == 2)
                System.out.println(MyMath.checker(ob.isPrime(), num) ? "PRIME" : "COMPOSITE");
            else
                System.out.println(MyMath.checker(ob.isPalindrome(), num) ? "PALINDROME" : "NOT PALINDROME");
        }
    }
}
