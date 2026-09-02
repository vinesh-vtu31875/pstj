import java.util.*;

public class w9s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String tag = sc.next();
            map.put(tag, map.getOrDefault(tag, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}