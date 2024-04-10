import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        for(int r = 0; r < row; r++) {
            System.out.println("*".repeat(col));
        }
    }
}