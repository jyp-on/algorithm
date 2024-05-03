import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static char[] arr;
    static Set<Character> mo;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visit = new boolean[C];
        mo = new HashSet<>();
        mo.add('a'); mo.add('e'); mo.add('i'); mo.add('o'); mo.add('u');
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        DFS(0, "A");
    }

    static void DFS(int start, String res) {
        if(res.length() == L+1) {
            int mo_cnt = 0;
            int ja_cnt = 0;
            for(int i= 1; i < res.length(); i++) {
                if(mo.contains(res.charAt(i))) {
                    mo_cnt++;
                } else {
                    ja_cnt++;
                }
            }
            if(mo_cnt < 1 || ja_cnt <2) return;

            res = res.replaceFirst("A", "");
            System.out.println(res);
            return;
       }

        for(int i = start; i < arr.length; i++) {
            if((int)arr[i] > (int)res.charAt(res.length()-1)) {
                if(!visit[i]) {
                    visit[i] = true;
                    DFS(i+1,res+arr[i]);
                    visit[i] = false;
                }
            }
        }
    }
}