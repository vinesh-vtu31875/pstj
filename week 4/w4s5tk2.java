import java.util.*;

public class w4s5tk2 {
    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            for (int i = left; i <= right; i++) {
                elements.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix[i][right]);
            }

            for (int i = right - 1; i >= left; i--) {
                elements.add(matrix[bottom][i]);
            }

            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix[i][left]);
            }

            int len = elements.size();
            int shift = r % len;

            int index = 0;

            for (int i = left; i <= right; i++) {
                matrix[top][i] = elements.get((shift + index++) % len);
            }

            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = elements.get((shift + index++) % len);
            }

            for (int i = right - 1; i >= left; i--) {
                matrix[bottom][i] = elements.get((shift + index++) % len);
            }

            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = elements.get((shift + index++) % len);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}
