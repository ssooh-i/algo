package boj.intensification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        char max = ' ';
        int maxInt = -1;
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[(int)str.charAt(i)-'A'] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == maxInt){
                max = '?';
            }else if(arr[i] > maxInt){
                max = (char) (i + 'A');
                maxInt = arr[i];
            }
        }
        System.out.println(max);
    }
}


