package boj.sunjobu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15654_Main {

    public static int N, M;
    public static int[] element; //요소 저장할 곳
    public static int[] arr; //답을 저장할 곳
    public static boolean[] isVisited; //방문했는지 판별
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 2 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(i == 0){
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                element = new int[N]; //N크기만큼 배열 생성
                isVisited = new boolean[N];
            }if(i == 1){
                for (int j = 0; j < N; j++) {
                    element[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(element);//정렬
            }
        }

        arr = new int[M]; //길이가 M될 때까지 추가될 arr

        comb(0);//depth
        System.out.println(sb);

    }

    static void comb(int depth) {
        //기저 조건
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!isVisited[i]){
                isVisited[i] = true;
                arr[depth] = element[i];
                comb( depth+1);
                isVisited[i]=false;
            }
        }

    }

}
