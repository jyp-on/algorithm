import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 사람들을 리스트에 초기화
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0; // 현재 인덱스

        while (list.size() > 0) {
            // M번째 사람의 인덱스를 계산
            index = (index + M - 1) % list.size();

            // M번째 사람을 제거하고 결과에 추가
            sb.append(list.remove(index) + ", ");
        }

        // 결과 출력

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
}
