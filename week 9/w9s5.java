import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

try {
    int n = sc.nextInt();
    int p = sc.nextInt();
    System.out.println(n / p);
} catch (InputMismatchException e) {
    System.out.println("java.util.InputMismatchException");
} catch (ArithmeticException e) {
    System.out.println(e);
}
    }}