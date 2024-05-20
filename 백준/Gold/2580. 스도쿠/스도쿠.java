import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[9][9];
        visit = new boolean[9][9];
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
    }

    static void DFS(int row, int col) {
        if(col == 9) { // 해당 열이 다 채워졌으면 다음 행으로 넘어감
            DFS(row + 1, 0);
            return;
        }

        if(row == 9) { // 모든 판이 채워졌으니 출력후 종료
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(board[row][col] == 0) {
            for(int i=1; i<=9; i++) {
                if(possibility(row, col, i)) {
                    board[row][col] = i;
                    DFS(row, col + 1);
                }
            }
            board[row][col] = 0;
            return; // 끝까지 갔는데도 스도쿠가 다 안채워진 경우 Back
        }
        
        DFS(row, col + 1);
    }

    static boolean possibility(int row, int col, int value) {
        // 같은 행에 같은 같은 원소가 있는지 검사
        for(int i=0; i<9; i++) {
            if(board[row][i] == value) {
                return false;
            }
        }

        // 같은 열에 같은 원소가 있는지 검사
        for(int i=0; i<9; i++) {
            if(board[i][col] == value) {
                return false;
            }
        }

        int row_start = row / 3 * 3;
        int col_start = col / 3 * 3;

        for(int i=row_start; i<row_start + 3; i++) {
            for(int j=col_start; j<col_start + 3; j++) {
                if(board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}