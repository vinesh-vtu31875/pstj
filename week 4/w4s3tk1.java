import java.util.*;

public class w4s3tk1 {
    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String period = s.substring(8, 10);

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d", hour) + s.substring(2, 8);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(timeConversion(s));
        sc.close();
    }
}
