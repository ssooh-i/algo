package boj.sunjobu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13251 {
    static int N,M,K; //조약돌 수, 색상수, 뽑는 조약돌 수
    static double answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         M = Integer.parseInt(br.readLine());
         arr = new int[M];
         N = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            N += arr[i];
        }

        K = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i = 0; i < M; i++) {
            comb(i);
        }

        System.out.println(answer>=1 ? 1: answer);
    }

    static void comb(int pick){
        if(arr[pick] >= K){
            int temp = N;
            int temp2 = K;
            //K개만큼 뽑는다
            double tmpAnswer = 1;
            while (temp2-- > 0){ //뽑을 때마다 총 개수가 줄어든다
                tmpAnswer *= (arr[pick]-- / (double) temp--); //형변환
            }
            //경우의 수 구해서 합치기
            answer += tmpAnswer;
        }
        return;
    }
}
