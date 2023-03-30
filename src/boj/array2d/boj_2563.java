package boj.array2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] paper = new int[100][100];
        int count = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = 1;
                }
            }
        }
            for(int j = 0; j<100; j++){
                for(int k = 0; k<100; k++){
                    if(paper[j][k] == 1){
                        count++;
                    }
                }
            }


        System.out.println(count);
        br.close();
    }
}
