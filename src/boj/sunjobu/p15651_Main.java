package boj.sunjobu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class p15651_Main {

    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정적변수 N과 M을 초기화해준다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M]; //길이가 M될 때까지 추가될 arr

        // 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다.
        dfs(1,0);//startPoint, depth
        System.out.println(sb);

    }

    static void dfs(int sp, int depth) {
        //기저 조건
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        //자기도 선택할 수 있게 하고 넘기기
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(i+1, depth+1);
        }

    }

}
