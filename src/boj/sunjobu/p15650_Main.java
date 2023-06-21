package boj.sunjobu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class p15650_Main {

    public static int N;	// 정적변수로 변경
    public static int M;	// 정적변수로 변경
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
        for (int i = sp; i <= N; i++) { //포인트는 시작점부터 시작해서 N까지
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
        return;
    }

}
