package boj.array2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //command+option+l 자동완성
        int N = 9;
        int[][] matrix = new int[N][N];
        int max = Integer.MIN_VALUE;
        int row = -1;
        int col = -1;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] arr = line.split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(arr[j]);
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((row + 1) + " " + (col + 1));
    }

}
