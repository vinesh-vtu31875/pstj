import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            set.add(a + " " + b);
            System.out.println(set.size());
        }

        sc.close();
    }
}