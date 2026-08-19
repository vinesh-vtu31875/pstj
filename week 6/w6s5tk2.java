import java.io.*;
import java.util.*;

public class Solution {

    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 1, 0, n - 1);
        }

        void build(int[] arr, int node, int l, int r) {
            if (l == r) {
                tree[node] = arr[l];
                return;
            }

            int mid = (l + r) / 2;

            build(arr, node * 2, l, mid);
            build(arr, node * 2 + 1, mid + 1, r);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) {
                return 0;
            }

            if (ql <= l && r <= qr) {
                return tree[node];
            }

            int mid = (l + r) / 2;

            return Math.max(
                query(node * 2, l, mid, ql, qr),
                query(node * 2 + 1, mid + 1, r, ql, qr)
            );
        }

        int query(int l, int r) {
            if (l > r) {
                return 0;
            }
            return query(1, 0, n - 1, l, r);
        }
    }

    static int[] manacherOdd(String s) {
        int n = s.length();
        int[] d = new int[n];

        int l = 0;
        int r = -1;

        for (int i = 0; i < n; i++) {
            int k = i > r ? 1 : Math.min(d[l + r - i], r - i + 1);

            while (i - k >= 0 && i + k < n &&
                   s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }

            d[i] = k - 1;

            if (i + d[i] > r) {
                l = i - d[i];
                r = i + d[i];
            }
        }

        return d;
    }

    static int[] manacherEven(String s) {
        int n = s.length();
        int[] d = new int[n];

        int l = 0;
        int r = -1;

        for (int i = 0; i < n; i++) {
            int k = i > r ? 0 : Math.min(d[l + r - i + 1], r - i + 1);

            while (i - k - 1 >= 0 && i + k < n &&
                   s.charAt(i - k - 1) == s.charAt(i + k)) {
                k++;
            }

            d[i] = k;

            if (i + d[i] - 1 > r) {
                l = i - d[i];
                r = i + d[i] - 1;
            }
        }

        return d;
    }

    static int longestOdd(int start, int n, SegmentTree tree) {
        int low = 0;
        int high = (n - 1) / 2;
        int best = 0;

        while (low <= high) {
            int k = (low + high) / 2;

            int left = start + k;
            int right = start + n - 1 - k;

            if (left <= right && tree.query(left, right) >= k) {
                best = k;
                low = k + 1;
            } else {
                high = k - 1;
            }
        }

        return 2 * best + 1;
    }

    static int longestEven(int start, int n, SegmentTree tree) {
        int low = 1;
        int high = n / 2;
        int best = 0;

        while (low <= high) {
            int k = (low + high) / 2;

            int left = start + k;
            int right = start + n - k;

            if (left <= right && tree.query(left, right) >= k) {
                best = k;
                low = k + 1;
            } else {
                high = k - 1;
            }
        }

        return 2 * best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        String doubled = s + s;

        int[] odd = manacherOdd(doubled);
        int[] even = manacherEven(doubled);

        SegmentTree oddTree = new SegmentTree(odd);
        SegmentTree evenTree = new SegmentTree(even);

        StringBuilder out = new StringBuilder();

        for (int start = 0; start < n; start++) {
            int oddLength = longestOdd(start, n, oddTree);
            int evenLength = longestEven(start, n, evenTree);

            out.append(Math.max(oddLength, evenLength)).append('\n');
        }

        System.out.print(out);
    }
}