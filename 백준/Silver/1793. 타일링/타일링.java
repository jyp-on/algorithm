import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BigInteger dp[];

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        
        dp = new BigInteger[251]; // 0~250범위의 배열을 할당한다.

        dp[0] = new BigInteger("1"); // 아무것도 설치하지 않는 경우의 수
        dp[1] = new BigInteger("1"); // n이 1일 때 경우의 수
        dp[2] = new BigInteger("3"); // n이 2일 때 경우의 수

        for(int i=3;i<=250;i++) {
            dp[i] = dp[i-2].multiply(new BigInteger("2"));
            dp[i] = dp[i].add(dp[i-1]);
        }

        while(sc.hasNextInt()) { // 입력이 존재하면 계속 반복한다. , 테스트 케이스가 존재하지 않기 때문
            int n=sc.nextInt(); // n이 들어오면
            System.out.println(dp[n]); // 해당 n값을 출력한다.
        }
    }
}