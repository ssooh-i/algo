package boj.array2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        String[] lines = new String[N];
        int len = -1;

        for (int i = 0; i < N; i++) {
            lines[i] = br.readLine();
            len = Math.max(len, lines[i].length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < lines.length ; j++) {
                if(lines[j].length() <= i){
                    continue;
                }
                sb.append(lines[j].charAt(i));
            }
        }
        System.out.println(sb);
        //문자열은 equals 비교해서 boolean값으로 알려줌
//        System.out.println(sb.toString().equals("Aa0aPAf985Bz1EhCz2W3D1gkD6x"));
    }
}
