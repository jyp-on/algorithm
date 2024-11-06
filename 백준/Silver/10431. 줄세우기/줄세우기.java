import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            LinkedList<Integer> q = new LinkedList<>();
            int cnt=0;
            for(int j=0; j<20; j++) {
                int x = Integer.parseInt(st.nextToken());
                int insertPos = 0;
                while(insertPos < q.size() && q.get(insertPos) < x) {
                    insertPos++;
                }

                q.add(insertPos, x);
                cnt+=q.size()-insertPos-1;

            }
            System.out.println(t + " " + cnt);
        }
    }
}