package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1912_슬라이딩윈도우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //맨 처음 입력받은 원소로 초기화
        int maxSum = arr[0]; //연속 부분합 저장
        int currentSum = arr[0]; //현재까지 연속 부분합 저장

        for (int i = 1; i < n; i++) { //2번째 원소부터 끝까지 반복
            //가장 큰 값 찾는 것
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxSum);

        System.out.println(sb.toString());

        br.close();
    }
}