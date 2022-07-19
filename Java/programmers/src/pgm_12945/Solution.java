package pgm_12945;

public class Solution {
    public int solution(int n) {
        return fibonacci(n);
    }

    public int fibonacci(int input) {
        int k = 0;
        int[][] ZERO = {{1, 0}, {0, 1}};
        int[][] BASE = {{1, 1}, {1, 0}};
        int[][] result = ZERO;
        if (input < 2) {
            return input + 1;
        } else {
            while (k < input) {
                result = matrixMultiply(result, BASE);
                k++;
            }
            return result[0][1];
        }
    }

    static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {
        int m1 = matrix1.length;
        int n1 = matrix1[0].length;
        int n2 = matrix2[0].length;
        int[][] temp = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    temp[i][j] += (matrix1[i][k] % 1234567 * matrix2[k][j] % 1234567) % 1234567;
                }
            }
        }
        return temp;
    }

}
