package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11403_Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        int[][] graph = new int[num][num];
        int[][] result = new int[num][num];

        // 입력
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());;
            }
        }

        Queue<Integer> queue;
        boolean[] visited;

        for(int i = 0; i < num; i++) { // 각 정점마다 탐색을 진행.
            // 아래부터는 dfs 탐색.
            queue = new LinkedList<Integer>();
            visited = new boolean[num];
            queue.offer(i);

            int tmp;
            while(!queue.isEmpty()) {
                tmp = queue.poll();
                for(int j = 0; j < num; j++) {
                    if(graph[tmp][j] == 1 && visited[j] != true) {
                        queue.offer(j);
                        visited[j] = true;
                        result[i][j] = 1; // 만약 i번째 정점에서 j를 거친다면 1을 표시.
                    }
                }
            }
        }

        // 출력
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num ; j++)
                System.out.print(result[i][j]+" ");
            System.out.println();
        }
        return;
    }
}