import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1;
        int sum = 0;
        for(int i=1; i<=10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();
            sum += (in - out);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}