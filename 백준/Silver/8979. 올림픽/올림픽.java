import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 국가 정보를 저장하는 배열
        int[][] countries = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 금, 은, 동 순으로 내림차순 정렬
        Arrays.sort(countries, (o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1]; // 금메달 비교
            if (o1[2] != o2[2]) return o2[2] - o1[2]; // 은메달 비교
            return o2[3] - o1[3];                     // 동메달 비교
        });

        // 등수 찾기
        int rank = 1;
        int prevGold = -1, prevSilver = -1, prevBronze = -1;

        for (int i = 0; i < n; i++) {
            // 현재 국가와 이전 국가의 메달 수가 다르면 등수를 갱신
            if (countries[i][1] != prevGold || countries[i][2] != prevSilver || countries[i][3] != prevBronze) {
                rank = i + 1; // 새로운 등수는 현재 인덱스 + 1
                prevGold = countries[i][1];
                prevSilver = countries[i][2];
                prevBronze = countries[i][3];
            }

            // 목표 국가(K)의 등수를 찾으면 출력 후 종료
            if (countries[i][0] == k) {
                System.out.println(rank);
                break;
            }
        }
    }
}
