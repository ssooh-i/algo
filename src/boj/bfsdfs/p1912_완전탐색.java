package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1912_완전탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = Integer.MIN_VALUE; //가장 작은 수로 초기화를 해서 합해진 값이 무조건 높게 설정

        for (int start = 0; start < n; start++) { //처음부터 끝까지 순회
            int sum = 0;
            for (int end = start; end < n; end++) { //시작부터 끝 인덱스까지 순회
                //연속된 부분의 수열의 합
                sum += arr[end];
                maxSum = Math.max(maxSum, sum);
            }
        }

        sb.append(maxSum);

        System.out.println(sb.toString());

        br.close();
    }
}