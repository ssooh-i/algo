package boj.sunjobu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p12101_Main {
    static int n, k;
    static int cnt = 0; //k번째까지 더해지는 지 계산할 친구
    static Stack<Integer> stack = new Stack<>(); //숫자 들어갈 곳
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dfs(0);

        if (cnt != k) {
            System.out.println(-1);
        }

    }

    static void dfs(int sum) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            cnt++;
            if (cnt == k) {
                StringBuilder sb = new StringBuilder();
                while (!stack.empty()){
                    sb.append(stack.pop()).append('+');
                }
                String answer = sb.reverse().toString().substring(1, sb.toString().length());
                System.out.print(answer);
            }
            return;
        }
        //sum에 1,2,3 중에서 골라서 더하기
        for(int i = 1; i<=3; i++){
            stack.push(i);
            dfs(sum+i) ;
            if(cnt == k){
                return;
            }
            stack.pop();
        }
    }
}
