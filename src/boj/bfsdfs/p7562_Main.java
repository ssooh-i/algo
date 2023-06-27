package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p7562_Main {

    static int tc;
    static int n;
    static int x1,y1;
    static int x2,y2;

    // 10시 방향부터 시계방향으로 8가지 이동위치 지정
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};

    //방문체크하기 위해 선언, 거리 측정 겸 방문 체크를 동시에 하기 위해 int[][] 선언
    static int[][] visited = new int[301][301];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tc = Integer.parseInt(st.nextToken());

        while(tc--!=0){ //테스트 케이스만큼 반복
            st = new StringTokenizer(br.readLine()); //체스판 한변의 길이
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()); //현재 나이트의 위치
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()); // 나이트가 이동하려는 위치
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            cleanVisited(); //배열의 초기값은 -1로 설정


            bfs(x1,y1,x2,y2); //현재위치와 이동하려는 위치 받기

            System.out.println(visited[x2][y2]);
        }

    }

    public static void bfs(int a,int b,int c,int d){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a,b));
        visited[a][b] = 0; //처음 방문한 곳은 0으로 바꿔주기, 시작점 체크

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == c && p.y == d) break; //목표 위치랑 같은 지 판별

            for(int i=0;i<8;i++){
                //현재위치에서 dx[i]와 dy[i]의 값만큼 이동한 새로운 값 생성
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                //범위 체크하고, 방문을 안했거나 현재 위치보다 적은 횟수로 방문한 경우에 q에 넣기
                if(0<=nx && nx<n && 0<=ny & ny<n &&
                        (visited[nx][ny]==-1 || visited[p.x][p.y]+1 < visited[nx][ny])
                ){
                    visited[nx][ny] = visited[p.x][p.y]+1; //현재까지 이동한 횟수 +1
                    q.add(new Point(nx,ny));
                }
            }
        }
    }

    //방문체크 하기 전 visited배열 -1로 초기화
    public static void cleanVisited(){
        for(int i=0;i<=300;i++)
            for(int j=0;j<=300;j++)
                visited[i][j]=-1;
    }

    //좌표 위치
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
