package boj.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2085_Main { //사탕게임 브루트포스
    static int[][] board; // 게임판 배열
    static int N; // 게임판 크기
    static int maxCandies = 0; // 최대 사탕 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 게임판 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j); // 각 위치의 사탕 종류 저장
            }
        }

        // 가로로 인접한 사탕 교환 시도
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swapAndCalculate(i, j, i, j + 1); // 사탕 교환 후 최대 개수 계산
            }
        }

        // 세로로 인접한 사탕 교환 시도
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swapAndCalculate(j, i, j + 1, i); // 사탕 교환 후 최대 개수 계산
            }
        }

        sb.append(maxCandies);
        System.out.println(sb.toString());
    }

    private static void swapAndCalculate(int x1, int y1, int x2, int y2) {
        // 사탕 교환
        int temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;

        // 교환 후 최대 사탕 개수 계산
        calculateMaxCandies();

        // 원래 위치로 사탕 복구
        temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static void calculateMaxCandies() {
        // 가로로 최대 사탕 개수 계산
        for (int i = 0; i < N; i++) {
            int count = 1; // 연속된 사탕 개수 초기화
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) { // 연속된 사탕이라면
                    count++; // 개수 증가
                } else {
                    maxCandies = Math.max(maxCandies, count); // 최대 사탕 개수 업데이트
                    count = 1; // 개수 초기화
                }
            }
            maxCandies = Math.max(maxCandies, count); // 마지막 연속된 사탕 개수    maxCandies = Math.max(maxCandies, count); // 최대 사탕 개수 업데이트
        }

        // 세로로 최대 사탕 개수 계산
        for (int i = 0; i < N; i++) {
            int count = 1; // 연속된 사탕 개수 초기화
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) { // 연속된 사탕이라면
                    count++; // 개수 증가
                } else {
                    maxCandies = Math.max(maxCandies, count); // 최대 사탕 개수 업데이트
                    count = 1; // 개수 초기화
                }
            }
            maxCandies = Math.max(maxCandies, count); // 마지막 연속된 사탕 개수 업데이트
        }
    }
}