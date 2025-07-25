class Solution {
    public String intToRoman(int num) {
        int A = num / 1000;
        int B = num / 100;
        int C = num / 10;
        int D = num % 10;

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        return null;
    }
}