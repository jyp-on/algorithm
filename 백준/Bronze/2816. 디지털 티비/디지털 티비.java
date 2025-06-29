import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(br.readLine());
        }

        int p = 0; // 화살표
        StringBuilder ans = new StringBuilder();
        while(true) {
            // KBS1을 찾을때까지 1번 액션으로 화살표를 내린다.
            if(!list.get(p).equals("KBS1")) {
                p++;
                ans.append("1");
                continue;
            }
            // KBS1을 찾았으면 제일 상단까지 4번 액션으로 올린다.
            // P의 수만큼 4를 ans에 추가하고 KBS1을 제일 처음으로 변경
            // P도 0으로 변경
            ans.append("4".repeat(p));
            String temp = list.remove(p);
            p = 0;
            list.add(0, temp);
            break;
        }

        while(true) {
            if(!list.get(p).equals("KBS2")) {
                p++;
                ans.append("1");
                continue;
            }

            ans.append("4".repeat(p-1));
            break;
        }


//        System.out.println(list);
        System.out.println(ans);

    }


}