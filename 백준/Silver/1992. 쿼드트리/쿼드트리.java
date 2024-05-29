import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        quad(0, 0, n);
        System.out.println(sb);
    }

    static void quad(int x, int y, int size) {
        if(zip(x, y, size, arr[x][y])) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append("(");
        quad(x, y, size/2);
        quad(x, y + size/2, size/2);
        quad(x + size/2, y, size/2);
        quad(x + size/2, y + size/2, size/2);
        sb.append(")");
    }

    static boolean zip(int x, int y, int size, int val) {
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(arr[i][j] != val) {
                    return false;
                }
            }
        }

        return true; // 하나의 값으로 압축
    }
}