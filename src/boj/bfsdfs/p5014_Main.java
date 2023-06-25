package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p5014_Main {
    static int f, s, g, u, d;
    static int visited[]; //방문체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        f = Integer.parseInt(st.nextToken());//최고층
        s = Integer.parseInt(st.nextToken());//강호 층
        g = Integer.parseInt(st.nextToken());//가야할 곳
        u = Integer.parseInt(st.nextToken());//업
        d = Integer.parseInt(st.nextToken());//다운

        visited = new int[f + 1]; //최고층 길이 +1, 이유는 첫 시작점을 체크해야해서

        BFS(f, s, g, u, d);
    }

    static void BFS(int f, int s, int g, int u, int d) {
        Queue<Integer> q = new LinkedList<Integer>(); //BFS는 큐로 푼다
        q.add(s); //요소 추가
        visited[s] = 1;//시작점 방문(버튼 안눌렀지만 1로 표시)

        while (!q.isEmpty()) {
            int c = q.poll();//현재위치 꺼내기

            if (c == g) {//현재위치 = 가야할 곳
                System.out.println(visited[c] - 1);//맨 처음 버튼 누른 것처럼 한거 뺀다
            }

            if (c + u <= f && visited[c + u] == 0) {//현재위치+업<= 최고층 && 방문 안했으면
                visited[c + u] = visited[c] + 1;
                q.add(c + u);
            }

            if (c - d > 0 && visited[c - d] == 0) {//현재위치-다운 > 0 && 방문 안했으면
                visited[c - d] = visited[c] + 1;
                q.add(c - d);
            }

        }

        if (visited[g] == 0)
            System.out.println("use the stairs");

    }
}
