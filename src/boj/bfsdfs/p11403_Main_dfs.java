package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11403_Main_dfs {
    static int n;
    static int[][] map;
    //인접행렬 형식으로 보여 줄 새로운 배열
    static int[][] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, new boolean[n]);
        }

        show(result);
    }

    //시작 정점, current(현재정점), 방문 여부를 파라미터로 들고 간다
//시작 정점에서 현재 정점으로 가는 경로가 있을 경우 result배열에 해당 경로를 1로 표시
//해당 정점에서 다음 정점으로 이동함
    static void dfs(int start, int current, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (map[current][i] == 1 && !visited[i]) {
                visited[i] = true;
                result[start][i] = 1;
                dfs(start, i, visited);
            }
        }
    }

    static void show(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}