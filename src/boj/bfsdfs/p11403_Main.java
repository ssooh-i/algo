package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p11403_Main {
    static int n;
    static int[][] map;
    static boolean[] visited;
    //인접행렬 형식으로 보여 줄 새로운 배열
    static int[][] result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];
        result = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        //매번 정해야 하므로 bfs를 한번 하고 나면 visited를 초기화 해준다.
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i]) {
                    bfs(i,j);
                    Arrays.fill(visited, false); //초기화해주는 함수
                }
            }
        }

        show(result); //배열출력하는 함수
    }
    //bfs를 통하여 i에서 j로 가는 경로를 구하여 그 경로가 0보다 크면 result에 추가시켜준다.
    //이렇게 해야 i에서 i로 돌아오는 경우 바로 bfs가 종료되는 것을 막아줄 수 있다.
    static void bfs(int start, int end) {
        int[] count = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);

        loop : while(!q.isEmpty()) {
            int v = q.poll();

            if(v == end) {
                if(count[v] > 0) {
                    result[start][end] = 1;
                    break loop;
                }
            }

            for(int i=0; i<n; i++) {
                if(map[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count[i] = count[v] + 1;
                }
            }
        }
    }

    static void show(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}