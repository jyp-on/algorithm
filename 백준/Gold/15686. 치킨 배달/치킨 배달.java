import java.util.*;
import java.io.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] arr;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int minDist = Integer.MAX_VALUE;
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) {
                    person.add(new Point(i, j));
                } else if(arr[i][j]==2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];
        DFS(0, 0); // 치킨 집 고르기
        System.out.println(minDist);
    }

    static void DFS(int start, int cnt) {
        if(cnt == M) {
            int distSum = 0;
            for(int i=0; i<person.size(); i++) {
                int temp = Integer.MAX_VALUE; // 사람마다 제일 가까운 치킨거리 -> temp
                for(int j=0; j<chicken.size(); j++) {
                    if(open[j]) {
                        int dist = (Math.abs(person.get(i).x - chicken.get(j).x)
                                + Math.abs(person.get(i).y - chicken.get(j).y));
                        temp = Math.min(temp, dist);
                    }
                }
                distSum += temp;
            }

            minDist = Math.min(minDist, distSum);
            return;
        }

        for(int i=start; i<chicken.size(); i++) {
            if(!open[i]) {
                open[i] = true;
                DFS(i+1, cnt+1);
                open[i] = false;
            }
        }
    }
}