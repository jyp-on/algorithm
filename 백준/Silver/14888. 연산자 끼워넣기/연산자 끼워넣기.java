import java.util.*;
import java.io.*;

public class Main {
    static int[] op = new int[4];
    static int N;
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for(int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
        }
        for(int i=0; i<4; i++) {
            op[i] = sc.nextInt();
        }
        DFS(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int depth, int sum) {
        if(depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        } else {
            for(int i=0; i<4; i++) {
                if(op[i]>0) {
                    op[i]--;
                    if(i==0) {
                        DFS(depth+1, sum+nums[depth]);
                    } else if(i==1) {
                        DFS(depth+1, sum-nums[depth]);
                    } else if(i==2) {
                        DFS(depth+1, sum*nums[depth]);
                    } else {
                        if(sum<0) {
                            DFS(depth+1, ((sum*-1)/nums[depth])*-1);
                        } else if(sum>0) {
                            DFS(depth+1, sum/nums[depth]);
                        } else {
                            DFS(depth+1, 0);
                        }
                    }
                    op[i]++;
                }
            }
        }
    }
}