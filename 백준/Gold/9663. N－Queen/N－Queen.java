import java.util.Scanner;

public class Main {
    static int[] arr;
    static int N;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        count = 0;
        nQueen(0);
        System.out.println(count);
    }

    // col 기준으로 오른쪽으로 밀고 나감
    public static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i=0; i<N; i++) {
            arr[depth] = i;
            if(check(depth)) {
                nQueen(depth+1);
            }
        }
    }

    public static boolean check(int col) {
        for(int i=0; i<col; i++) { // 행 겹치는 경우
            if(arr[i] == arr[col]) {
                return false;
            }
            if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) { // 대각선 겹치는 경우
                return false;
            }
        }
        return true;
    }
}