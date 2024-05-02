import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        boolean[] w_check = new boolean[width+1];
        boolean[] h_check = new boolean[height+1];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int where = Integer.parseInt(st.nextToken());
            int what = Integer.parseInt(st.nextToken());
            if(where == 0){
                h_check[what] = true;
            } else if(where == 1) {
                w_check[what] = true;
            }
        }

        int tmp = 0;
        int max_w = 0;
        for(int i=1; i<=width; i++){
            tmp++;
            if(w_check[i]) {
                max_w = Math.max(max_w, tmp);
                tmp = 0;
            }
        }
        max_w = Math.max(max_w, tmp);

        tmp = 0;
        int max_h = 0;
        for(int i=1; i<=height; i++){
            tmp++;
            if(h_check[i]) {
                max_h = Math.max(max_h, tmp);
                tmp = 0;
            }
        }
        max_h = Math.max(max_h, tmp);

        System.out.println(max_w * max_h);

    }
}