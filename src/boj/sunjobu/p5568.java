package boj.sunjobu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p5568 {
    //조힙
    private String[] arr;
    private int n, k;
    private HashSet<String> chk = new HashSet<>(); //중복 제거해서 서로 다른 string만 파악
    private boolean[] v;
    //1. 모든 가능한 숫자조합을 탐색
    //2. 중복을 제거한 후 저장하여
    //3. 저장한 거 크기로 서로 다른 숫자조합의 개수 출력
    private void bf(int cnt, String cur) {
        if (cnt == k) { //조합완성되서 해쉬셋에 추가하기
            chk.add(cur);
            return;
        }
        //선택되지 않은 숫자를 하나씩 선택하고 true로 변경 후 조합시키기
        for (int i = 0; i < n; i++) {
            if (v[i]) continue;
            v[i] = true;
            bf(cnt+1, cur+arr[i]);
            //조합끝나면 다시 false로 바꾸기
            v[i] = false;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        v = new boolean[n]; //방문체크하기
        for (int i = 0; i < n; i++) arr[i] = br.readLine();

        bf(0, ""); //현재까지 선택한 숫자수, 현재까지 만들어 진 조합 수

        System.out.println(chk.size());
    }

    public static void main(String[] args) throws Exception {
        new p5568().solution();
    }
}