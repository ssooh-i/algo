package boj.sunjobu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5568_Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();
        String[] arr = str.split("-");
        char[] answer = new char[arr.length];

        for(int i =0; i< arr.length; i++){
            answer[i] = arr[i].charAt(0);
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }
    }
}
